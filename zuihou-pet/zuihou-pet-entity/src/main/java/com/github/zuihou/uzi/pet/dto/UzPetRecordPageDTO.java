package com.github.zuihou.uzi.pet.dto;

import java.time.LocalDateTime;
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
 * 宠物记录表
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
@ApiModel(value = "UzPetRecordPageDTO", description = "宠物记录表")
public class UzPetRecordPageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 宠物码ID
     */
    @ApiModelProperty(value = "宠物码ID")
    private Long petId;
    /**
     * 疫苗名称
     */
    @ApiModelProperty(value = "疫苗名称")
    @Length(max = 255, message = "疫苗名称长度不能超过255")
    private String name;
    /**
     * 总针数
     */
    @ApiModelProperty(value = "总针数")
    private Integer total;
    /**
     * 当前针数
     */
    @ApiModelProperty(value = "当前针数")
    private Integer current;
    /**
     * 注射日期
     */
    @ApiModelProperty(value = "注射日期")
    private LocalDate date;

}
