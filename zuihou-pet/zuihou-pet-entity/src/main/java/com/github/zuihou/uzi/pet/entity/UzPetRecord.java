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
 * 宠物记录表
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
@TableName("uz_pet_record")
@ApiModel(value = "UzPetRecord", description = "宠物记录表")
@AllArgsConstructor
public class UzPetRecord extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 宠物码ID
     */
    @ApiModelProperty(value = "宠物码ID")
    @TableField("pet_id")
    @Excel(name = "宠物码ID")
    private Long petId;

    /**
     * 疫苗名称
     */
    @ApiModelProperty(value = "疫苗名称")
    @Length(max = 255, message = "疫苗名称长度不能超过255")
    @TableField(value = "name", condition = LIKE)
    @Excel(name = "疫苗名称")
    private String name;

    /**
     * 总针数
     */
    @ApiModelProperty(value = "总针数")
    @TableField("total")
    @Excel(name = "总针数")
    private Integer total;

    /**
     * 当前针数
     */
    @ApiModelProperty(value = "当前针数")
    @TableField("current")
    @Excel(name = "当前针数")
    private Integer current;

    /**
     * 注射日期
     */
    @ApiModelProperty(value = "注射日期")
    @TableField("date")
    @Excel(name = "注射日期", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDate date;


    @Builder
    public UzPetRecord(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser, 
                    Long petId, String name, Integer total, Integer current, LocalDate date) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.petId = petId;
        this.name = name;
        this.total = total;
        this.current = current;
        this.date = date;
    }

}
