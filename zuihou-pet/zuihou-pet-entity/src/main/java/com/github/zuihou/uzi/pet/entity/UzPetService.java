package com.github.zuihou.uzi.pet.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import java.time.LocalTime;
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
 * 宠物服务预约表
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
@TableName("uz_pet_service")
@ApiModel(value = "UzPetService", description = "宠物服务预约表")
@AllArgsConstructor
public class UzPetService extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 宠物码ID
     */
    @ApiModelProperty(value = "宠物码ID")
    @TableField("pet_id")
    @Excel(name = "宠物码ID")
    private Long petId;

    /**
     * 预约分类ID
     */
    @ApiModelProperty(value = "预约分类ID")
    @TableField("category_id")
    @Excel(name = "预约分类ID")
    private Long categoryId;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    @TableField("date")
    @Excel(name = "日期", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDate date;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    @TableField("start")
    @Excel(name = "开始时间", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalTime start;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @TableField("end")
    @Excel(name = "结束时间", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalTime end;


    @Builder
    public UzPetService(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser, 
                    Long petId, Long categoryId, LocalDate date, LocalTime start, LocalTime end) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.petId = petId;
        this.categoryId = categoryId;
        this.date = date;
        this.start = start;
        this.end = end;
    }

}
