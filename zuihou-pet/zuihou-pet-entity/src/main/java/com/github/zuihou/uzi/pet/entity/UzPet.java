package com.github.zuihou.uzi.pet.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * 宠物码
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
@TableName("uz_pet")
@ApiModel(value = "UzPet", description = "宠物码")
@AllArgsConstructor
public class UzPet extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 二维码ID
     */
    @ApiModelProperty(value = "二维码ID")
    @TableField("qrcode_id")
    @Excel(name = "二维码ID")
    private Long qrcodeId;

    /**
     * 主人ID
     */
    @ApiModelProperty(value = "主人ID")
    @TableField("uid")
    @Excel(name = "主人ID")
    private Long uid;

    /**
     * 品种ID
     */
    @ApiModelProperty(value = "品种ID")
    @TableField("category_id")
    @Excel(name = "品种ID")
    private Long categoryId;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Length(max = 255, message = "姓名长度不能超过255")
    @TableField(value = "name", condition = LIKE)
    @Excel(name = "姓名")
    private String name;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    @TableField("birthday")
    @Excel(name = "生日", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDate birthday;

    /**
     * 体重
     */
    @ApiModelProperty(value = "体重")
    @TableField("weight")
    @Excel(name = "体重")
    private Float weight;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @Length(max = 255, message = "头像长度不能超过255")
    @TableField(value = "avatar", condition = LIKE)
    @Excel(name = "头像")
    private String avatar;


    @Builder
    public UzPet(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser, 
                    Long qrcodeId, Long uid, Long categoryId, String name, LocalDate birthday, 
                    Float weight, String avatar) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.qrcodeId = qrcodeId;
        this.uid = uid;
        this.categoryId = categoryId;
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.avatar = avatar;
    }

}
