package com.github.zuihou.uzi.pet.dto;

import java.time.LocalDateTime;
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
 * 宠物服务预约表
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
@ApiModel(value = "UzPetServicePageDTO", description = "宠物服务预约表")
public class UzPetServicePageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 宠物码ID
     */
    @ApiModelProperty(value = "宠物码ID")
    private Long petId;
    /**
     * 预约分类ID
     */
    @ApiModelProperty(value = "预约分类ID")
    private Long categoryId;
    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private LocalDate date;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private LocalTime start;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private LocalTime end;

}
