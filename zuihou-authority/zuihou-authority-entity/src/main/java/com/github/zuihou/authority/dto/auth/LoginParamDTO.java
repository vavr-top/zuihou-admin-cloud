package com.github.zuihou.authority.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

/**
 * 登录参数
 *
 * @author zuihou
 * @date 2020年01月05日22:18:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "LoginParamDTO", description = "登录参数")
public class LoginParamDTO {
    @ApiModelProperty(value = "验证码KEY")
    private String key;
    @ApiModelProperty(value = "验证码")
    private String code;

    @ApiModelProperty(value = "企业编号", example = "MDAwMA==")
    private String tenant;
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "微信iv")
    private String iv;

    @ApiModelProperty(value = "完整用户信息的加密数据")
    private String encryptedData;

    /**
     * password: 账号密码
     * refresh_token: 刷新token
     * captcha: 验证码
     */
    @ApiModelProperty(value = "授权类型", example = "captcha", allowableValues = "captcha,refresh_token,password,wxma")
    @NotEmpty(message = "授权类型不能为空")
    private String grantType;

    /**
     * 前端界面点击清空缓存时调用
     */
    @ApiModelProperty(value = "刷新token")
    private String refreshToken;
}
