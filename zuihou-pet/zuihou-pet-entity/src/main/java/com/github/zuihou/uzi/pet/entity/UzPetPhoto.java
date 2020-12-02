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
 * 宠物相册表
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
@TableName("uz_pet_photo")
@ApiModel(value = "UzPetPhoto", description = "宠物相册表")
@AllArgsConstructor
public class UzPetPhoto extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 宠物码ID
     */
    @ApiModelProperty(value = "宠物码ID")
    @TableField("pet_id")
    @Excel(name = "宠物码ID")
    private Long petId;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    @Length(max = 255, message = "标题长度不能超过255")
    @TableField(value = "title", condition = LIKE)
    @Excel(name = "标题")
    private String title;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    @Length(max = 255, message = "图片长度不能超过255")
    @TableField(value = "files", condition = LIKE)
    @Excel(name = "图片")
    private String files;


    @Builder
    public UzPetPhoto(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser, 
                    Long petId, String title, String files) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.petId = petId;
        this.title = title;
        this.files = files;
    }

}
