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
 * 二维码主表
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
@TableName("uz_qrcode")
@ApiModel(value = "UzQrcode", description = "二维码主表")
@AllArgsConstructor
public class UzQrcode extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 二维码编号
     */
    @ApiModelProperty(value = "二维码编号")
    @Length(max = 255, message = "二维码编号长度不能超过255")
    @TableField(value = "qrcode_no", condition = LIKE)
    @Excel(name = "二维码编号")
    private String qrcodeNo;

    /**
     * 加密ID
     */
    @ApiModelProperty(value = "加密ID")
    @Length(max = 255, message = "加密ID长度不能超过255")
    @TableField(value = "hash_id", condition = LIKE)
    @Excel(name = "加密ID")
    private String hashId;

    /**
     * 所属应用
     */
    @ApiModelProperty(value = "所属应用")
    @TableField("app_id")
    @Excel(name = "所属应用")
    private Long appId;

    /**
     * 渠道ID
     */
    @ApiModelProperty(value = "渠道ID")
    @TableField("channel_id")
    @Excel(name = "渠道ID")
    private Long channelId;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Length(max = 255, message = "备注长度不能超过255")
    @TableField(value = "remark", condition = LIKE)
    @Excel(name = "备注")
    private String remark;

    /**
     * 绑定时间
     */
    @ApiModelProperty(value = "绑定时间")
    @TableField("bind_time")
    @Excel(name = "绑定时间", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDateTime bindTime;

    /**
     * 绑定的用户ID
     */
    @ApiModelProperty(value = "绑定的用户ID")
    @TableField("uid")
    @Excel(name = "绑定的用户ID")
    private Long uid;

    /**
     * 二维码自定义标题
     */
    @ApiModelProperty(value = "二维码自定义标题")
    @Length(max = 255, message = "二维码自定义标题长度不能超过255")
    @TableField(value = "title", condition = LIKE)
    @Excel(name = "二维码自定义标题")
    private String title;

    /**
     * 二维码自定义描述
     */
    @ApiModelProperty(value = "二维码自定义描述")
    @Length(max = 255, message = "二维码自定义描述长度不能超过255")
    @TableField(value = "dsc", condition = LIKE)
    @Excel(name = "二维码自定义描述")
    private String dsc;


    @Builder
    public UzQrcode(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser, 
                    String qrcodeNo, String hashId, Long appId, Long channelId, String remark, 
                    LocalDateTime bindTime, Long uid, String title, String dsc) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.qrcodeNo = qrcodeNo;
        this.hashId = hashId;
        this.appId = appId;
        this.channelId = channelId;
        this.remark = remark;
        this.bindTime = bindTime;
        this.uid = uid;
        this.title = title;
        this.dsc = dsc;
    }

}
