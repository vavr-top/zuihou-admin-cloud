package com.github.zuihou.uzi.pet.dto;

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
 * 二维码主表
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
@ApiModel(value = "UzQrcodeSaveDTO", description = "二维码主表")
public class UzQrcodeSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 二维码编号
     */
    @ApiModelProperty(value = "二维码编号")
    @Length(max = 255, message = "二维码编号长度不能超过255")
    private String qrcodeNo;
    /**
     * 加密ID
     */
    @ApiModelProperty(value = "加密ID")
    @Length(max = 255, message = "加密ID长度不能超过255")
    private String hashId;
    /**
     * 所属应用
     */
    @ApiModelProperty(value = "所属应用")
    private Long appId;
    /**
     * 渠道ID
     */
    @ApiModelProperty(value = "渠道ID")
    private Long channelId;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Length(max = 255, message = "备注长度不能超过255")
    private String remark;
    /**
     * 绑定时间
     */
    @ApiModelProperty(value = "绑定时间")
    private LocalDateTime bindTime;
    /**
     * 绑定的用户ID
     */
    @ApiModelProperty(value = "绑定的用户ID")
    private Long uid;
    /**
     * 二维码自定义标题
     */
    @ApiModelProperty(value = "二维码自定义标题")
    @Length(max = 255, message = "二维码自定义标题长度不能超过255")
    private String title;
    /**
     * 二维码自定义描述
     */
    @ApiModelProperty(value = "二维码自定义描述")
    @Length(max = 255, message = "二维码自定义描述长度不能超过255")
    private String dsc;

}
