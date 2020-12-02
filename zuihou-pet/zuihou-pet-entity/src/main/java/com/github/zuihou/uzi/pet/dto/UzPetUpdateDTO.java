package com.github.zuihou.uzi.pet.dto;

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
import com.github.zuihou.base.entity.SuperEntity;
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
 * 宠物码
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
@ApiModel(value = "UzPetUpdateDTO", description = "宠物码")
public class UzPetUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;

    /**
     * 二维码ID
     */
    @ApiModelProperty(value = "二维码ID")
    private Long qrcodeId;
    /**
     * 主人ID
     */
    @ApiModelProperty(value = "主人ID")
    private Long uid;
    /**
     * 品种ID
     */
    @ApiModelProperty(value = "品种ID")
    private Long categoryId;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Length(max = 255, message = "姓名长度不能超过255")
    private String name;
    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private LocalDate birthday;
    /**
     * 体重
     */
    @ApiModelProperty(value = "体重")
    private Float weight;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @Length(max = 255, message = "头像长度不能超过255")
    private String avatar;
}
