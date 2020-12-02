package com.github.zuihou.uzi.pet.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 宠物专家表
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
@TableName("uz_pet_expert")
@ApiModel(value = "UzPetExpert", description = "宠物专家表")
@AllArgsConstructor
public class UzPetExpert extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Length(max = 255, message = "姓名长度不能超过255")
    @TableField(value = "name", condition = LIKE)
    @Excel(name = "姓名")
    private String name;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介")
    @Length(max = 255, message = "简介长度不能超过255")
    @TableField(value = "description", condition = LIKE)
    @Excel(name = "简介")
    private String description;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @Length(max = 255, message = "头像长度不能超过255")
    @TableField(value = "avatar", condition = LIKE)
    @Excel(name = "头像")
    private String avatar;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    @Length(max = 255, message = "电话长度不能超过255")
    @TableField(value = "mobile", condition = LIKE)
    @Excel(name = "电话")
    private String mobile;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @TableField("sort")
    @Excel(name = "排序")
    private Integer sort;


    @Builder
    public UzPetExpert(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser, 
                    String name, String description, String avatar, String mobile, Integer sort) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.name = name;
        this.description = description;
        this.avatar = avatar;
        this.mobile = mobile;
        this.sort = sort;
    }

}
