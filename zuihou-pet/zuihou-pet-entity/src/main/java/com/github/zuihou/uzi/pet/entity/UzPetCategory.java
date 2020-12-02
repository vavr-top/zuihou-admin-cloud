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
 * 宠物品种表
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
@TableName("uz_pet_category")
@ApiModel(value = "UzPetCategory", description = "宠物品种表")
@AllArgsConstructor
public class UzPetCategory extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 上级ID
     */
    @ApiModelProperty(value = "上级ID")
    @NotNull(message = "上级ID不能为空")
    @TableField("parent_id")
    @Excel(name = "上级ID")
    private Long parentId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "名称不能为空")
    @Length(max = 255, message = "名称长度不能超过255")
    @TableField(value = "label", condition = LIKE)
    @Excel(name = "名称")
    private String label;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @NotNull(message = "排序不能为空")
    @TableField("sort_value")
    @Excel(name = "排序")
    private Integer sortValue;


    @Builder
    public UzPetCategory(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser, 
                    Long parentId, String label, Integer sortValue) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.parentId = parentId;
        this.label = label;
        this.sortValue = sortValue;
    }

}
