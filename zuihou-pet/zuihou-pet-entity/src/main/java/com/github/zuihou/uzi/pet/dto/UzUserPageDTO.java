package com.github.zuihou.uzi.pet.dto;

import java.time.LocalDateTime;
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
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.github.zuihou.common.constant.DictionaryType;
import java.io.Serializable;

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
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "UzUserPageDTO", description = "用户表")
public class UzUserPageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * unionID
     */
    @ApiModelProperty(value = "unionID")
    @NotEmpty(message = "unionID不能为空")
    @Length(max = 255, message = "unionID长度不能超过255")
    private String unionid;
    /**
     * 微信ID
     */
    @ApiModelProperty(value = "微信ID")
    @Length(max = 255, message = "微信ID长度不能超过255")
    private String openid;
    /**
     * 小程序openid
     */
    @ApiModelProperty(value = "小程序openid")
    @Length(max = 255, message = "小程序openid长度不能超过255")
    private String openidMini;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "姓名不能为空")
    @Length(max = 255, message = "姓名长度不能超过255")
    private String nickname;
    /**
     * 性别:0:未知;1:男;2:女;
     */
    @ApiModelProperty(value = "性别:0:未知;1:男;2:女;")
    @NotNull(message = "性别:0:未知;1:男;2:女;不能为空")
    private Boolean sex;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    @NotEmpty(message = "电话不能为空")
    @Length(max = 50, message = "电话长度不能超过50")
    private String mobile;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @NotEmpty(message = "头像不能为空")
    @Length(max = 255, message = "头像长度不能超过255")
    private String avatar;
    /**
     * 认证姓名
     */
    @ApiModelProperty(value = "认证姓名")
    @NotEmpty(message = "认证姓名不能为空")
    @Length(max = 255, message = "认证姓名长度不能超过255")
    private String authName;
    /**
     * 认证身份证
     */
    @ApiModelProperty(value = "认证身份证")
    @NotEmpty(message = "认证身份证不能为空")
    @Length(max = 255, message = "认证身份证长度不能超过255")
    private String authIdcard;
    /**
     * 认证数据
     */
    @ApiModelProperty(value = "认证数据")
    @Length(max = 65535, message = "认证数据长度不能超过65,535")
    private String authData;
    /**
     * 认证状态:0:未认证;1:已认证;
     */
    @ApiModelProperty(value = "认证状态:0:未认证;1:已认证;")
    @NotNull(message = "认证状态:0:未认证;1:已认证;不能为空")
    private Boolean authStatus;
    /**
     * 认证时间
     */
    @ApiModelProperty(value = "认证时间")
    private LocalDateTime authTime;

}
