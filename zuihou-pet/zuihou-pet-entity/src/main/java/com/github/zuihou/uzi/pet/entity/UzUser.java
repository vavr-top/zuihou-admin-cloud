package com.github.zuihou.uzi.pet.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.zuihou.base.entity.Entity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.github.zuihou.common.constant.DictionaryType;
import static com.github.zuihou.utils.DateUtils.DEFAULT_DATE_TIME_FORMAT;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 实体类
 * 用户表
 * </p>
 *
 * @author zhaoyk
 * @since 2020-12-02
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("uz_user")
@ApiModel(value = "UzUser", description = "用户表")
@AllArgsConstructor
public class UzUser extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * unionID
     */
    @ApiModelProperty(value = "unionID")
    @NotEmpty(message = "unionID不能为空")
    @Length(max = 255, message = "unionID长度不能超过255")
    @TableField(value = "unionid", condition = LIKE)
    @Excel(name = "unionID")
    private String unionid;

    /**
     * 微信ID
     */
    @ApiModelProperty(value = "微信ID")
    @Length(max = 255, message = "微信ID长度不能超过255")
    @TableField(value = "openid", condition = LIKE)
    @Excel(name = "微信ID")
    private String openid;

    /**
     * 小程序openid
     */
    @ApiModelProperty(value = "小程序openid")
    @Length(max = 255, message = "小程序openid长度不能超过255")
    @TableField(value = "openid_mini", condition = LIKE)
    @Excel(name = "小程序openid")
    private String openidMini;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "姓名不能为空")
    @Length(max = 255, message = "姓名长度不能超过255")
    @TableField(value = "nickname", condition = LIKE)
    @Excel(name = "姓名")
    private String nickname;

    /**
     * 性别:0:未知;1:男;2:女;
     */
    @ApiModelProperty(value = "性别:0:未知;1:男;2:女;")
    @NotNull(message = "性别:0:未知;1:男;2:女;不能为空")
    @TableField("sex")
    @Excel(name = "性别:0:未知;1:男;2:女;", replace = {"是_true", "否_false", "_null"})
    private Boolean sex;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    @NotEmpty(message = "电话不能为空")
    @Length(max = 50, message = "电话长度不能超过50")
    @TableField(value = "mobile", condition = LIKE)
    @Excel(name = "电话")
    private String mobile;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @NotEmpty(message = "头像不能为空")
    @Length(max = 255, message = "头像长度不能超过255")
    @TableField(value = "avatar", condition = LIKE)
    @Excel(name = "头像")
    private String avatar;

    /**
     * 认证姓名
     */
    @ApiModelProperty(value = "认证姓名")
    @NotEmpty(message = "认证姓名不能为空")
    @Length(max = 255, message = "认证姓名长度不能超过255")
    @TableField(value = "auth_name", condition = LIKE)
    @Excel(name = "认证姓名")
    private String authName;

    /**
     * 认证身份证
     */
    @ApiModelProperty(value = "认证身份证")
    @NotEmpty(message = "认证身份证不能为空")
    @Length(max = 255, message = "认证身份证长度不能超过255")
    @TableField(value = "auth_idcard", condition = LIKE)
    @Excel(name = "认证身份证")
    private String authIdcard;

    /**
     * 认证数据
     */
    @ApiModelProperty(value = "认证数据")
    @Length(max = 65535, message = "认证数据长度不能超过65535")
    @TableField("auth_data")
    @Excel(name = "认证数据")
    private String authData;

    /**
     * 认证状态:0:未认证;1:已认证;
     */
    @ApiModelProperty(value = "认证状态:0:未认证;1:已认证;")
    @NotNull(message = "认证状态:0:未认证;1:已认证;不能为空")
    @TableField("auth_status")
    @Excel(name = "认证状态:0:未认证;1:已认证;", replace = {"是_true", "否_false", "_null"})
    private Boolean authStatus;

    /**
     * 认证时间
     */
    @ApiModelProperty(value = "认证时间")
    @TableField("auth_time")
    @Excel(name = "认证时间", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDateTime authTime;


    @Builder
    public UzUser(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser, 
                    String unionid, String openid, String openidMini, String nickname, Boolean sex, 
                    String mobile, String avatar, String authName, String authIdcard, String authData, Boolean authStatus, LocalDateTime authTime) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.unionid = unionid;
        this.openid = openid;
        this.openidMini = openidMini;
        this.nickname = nickname;
        this.sex = sex;
        this.mobile = mobile;
        this.avatar = avatar;
        this.authName = authName;
        this.authIdcard = authIdcard;
        this.authData = authData;
        this.authStatus = authStatus;
        this.authTime = authTime;
    }

}
