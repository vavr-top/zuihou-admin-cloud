package com.github.zuihou.oauth.granter;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.github.zuihou.authority.dto.auth.LoginParamDTO;
import com.github.zuihou.authority.entity.auth.User;
import com.github.zuihou.authority.entity.auth.UserToken;
import com.github.zuihou.base.R;
import com.github.zuihou.context.BaseContextHandler;
import com.github.zuihou.database.properties.MultiTenantType;
import com.github.zuihou.exception.code.ExceptionCode;
import com.github.zuihou.jwt.model.AuthInfo;
import com.github.zuihou.oauth.event.LoginEvent;
import com.github.zuihou.oauth.event.model.LoginStatusDTO;
import com.github.zuihou.oauth.granter.wxma.WxMaConfiguration;
import com.github.zuihou.oauth.utils.TimeUtils;
import com.github.zuihou.tenant.entity.Tenant;
import com.github.zuihou.tenant.enumeration.TenantStatusEnum;
import com.github.zuihou.utils.BizAssert;
import com.github.zuihou.utils.SpringUtils;
import com.github.zuihou.utils.StrHelper;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.github.zuihou.oauth.granter.WxMaTokenGranter.GRANT_TYPE;
import static com.github.zuihou.utils.BizAssert.gt;
import static com.github.zuihou.utils.BizAssert.notNull;

/**
 * @author zhaoyk
 * @createDate 2020/11/6 16:58
 * @modifyDate
 * @modifyUser
 */
@Slf4j
@Component(GRANT_TYPE)
public class WxMaTokenGranter extends AbstractTokenGranter {

    static final String GRANT_TYPE = "wxma";

    @Override
    public R<AuthInfo> grant(LoginParamDTO loginParam) {
        return this.login(loginParam);
    }

    @Override
    protected R<AuthInfo> login(LoginParamDTO loginParam) {
        if (StrHelper.isAnyBlank(loginParam.getCode(),loginParam.getIv(),loginParam.getEncryptedData())) {
            return R.fail("微信code、iv、encryptedData不能为空");
        }
        final WxMaService wxService = WxMaConfiguration.getMaService("wxae640c0693f3dc26");
        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(loginParam.getCode());
            //TODO 可以增加自己的逻辑，关联业务相关数据

            WxMaUserInfo wxMaUserInfo = wxService.getUserService().getUserInfo(session.getSessionKey(), loginParam.getEncryptedData(), loginParam.getIv());
            WxMaPhoneNumberInfo wxMaPhoneNumberInfo = wxService.getUserService().getPhoneNoInfo(session.getSessionKey(), loginParam.getEncryptedData(), loginParam.getIv());
        } catch (WxErrorException e) {
            return R.fail("微信登录失败");
        }

        // 1，检测租户是否可用
        if (!MultiTenantType.NONE.eq(databaseProperties.getMultiTenantType())) {
            Tenant tenant = this.tenantService.getByCode(loginParam.getTenant());
            notNull(tenant, "企业不存在");
            BizAssert.equals(TenantStatusEnum.NORMAL, tenant.getStatus(), "企业不可用~");
            if (tenant.getExpirationTime() != null) {
                gt(LocalDateTime.now(), tenant.getExpirationTime(), "企业服务已到期~");
            }
            BaseContextHandler.setTenant(tenant.getCode());
        }

        // 2.检测client是否可用
        R<String[]> checkR = checkClient();
        if (checkR.getIsError()) {
            return R.fail(checkR.getMsg());
        }

        // 3. 验证登录
        R<User> result = this.getUser(loginParam.getAccount(), loginParam.getPassword());
        if (result.getIsError()) {
            return R.fail(result.getCode(), result.getMsg());
        }

        // 4.查询用户的权限
        User user = result.getData();

        // 5.生成 token
        AuthInfo authInfo = this.createToken(user);

        UserToken userToken = getUserToken(checkR.getData()[0], authInfo);

        //成功登录事件
        SpringUtils.publishEvent(new LoginEvent(LoginStatusDTO.success(user.getId(), userToken)));
        return R.success(authInfo);
    }

    @Override
    protected R<User> getUser(String account, String password) {
        User user = this.userService.getByAccount(account);
        // 密码错误
        String passwordMd5 = cn.hutool.crypto.SecureUtil.md5(password);
        if (user == null) {
            return R.fail(ExceptionCode.JWT_USER_INVALID);
        }

        if (!user.getPassword().equalsIgnoreCase(passwordMd5)) {
            String msg = "用户名或密码错误!";
            // 密码错误事件
            SpringUtils.publishEvent(new LoginEvent(LoginStatusDTO.pwdError(user.getId(), msg)));
            return R.fail(msg);
        }

        // 密码过期
        if (user.getPasswordExpireTime() != null && LocalDateTime.now().isAfter(user.getPasswordExpireTime())) {
            String msg = "用户密码已过期，请修改密码或者联系管理员重置!";
            SpringUtils.publishEvent(new LoginEvent(LoginStatusDTO.fail(user.getId(), msg)));
            return R.fail(msg);
        }

        if (!user.getStatus()) {
            String msg = "用户被禁用，请联系管理员！";
            SpringUtils.publishEvent(new LoginEvent(LoginStatusDTO.fail(user.getId(), msg)));
            return R.fail(msg);
        }

        // 用户锁定
        Integer maxPasswordErrorNum = 0;
        Integer passwordErrorNum = Convert.toInt(user.getPasswordErrorNum(), 0);
        if (maxPasswordErrorNum > 0 && passwordErrorNum > maxPasswordErrorNum) {
            log.info("当前错误次数{}, 最大次数:{}", passwordErrorNum, maxPasswordErrorNum);

            LocalDateTime passwordErrorLockTime = TimeUtils.getPasswordErrorLockTime("0");
            log.info("passwordErrorLockTime={}", passwordErrorLockTime);
            if (passwordErrorLockTime.isAfter(user.getPasswordErrorLastTime())) {
                // 登录失败事件
                String msg = StrUtil.format("密码连续输错次数已达到{}次,用户已被锁定~", maxPasswordErrorNum);
                SpringUtils.publishEvent(new LoginEvent(LoginStatusDTO.fail(user.getId(), msg)));
                return R.fail(msg);
            }
        }

        return R.success(user);
    }
}
