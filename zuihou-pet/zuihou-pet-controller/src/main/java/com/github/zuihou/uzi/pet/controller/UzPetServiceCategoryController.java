package com.github.zuihou.uzi.pet.controller;

import com.github.zuihou.uzi.pet.entity.UzPetServiceCategory;
import com.github.zuihou.uzi.pet.dto.UzPetServiceCategorySaveDTO;
import com.github.zuihou.uzi.pet.dto.UzPetServiceCategoryUpdateDTO;
import com.github.zuihou.uzi.pet.dto.UzPetServiceCategoryPageDTO;
import com.github.zuihou.uzi.pet.service.UzPetServiceCategoryService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.github.zuihou.base.controller.SuperController;
import com.github.zuihou.base.R;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.zuihou.security.annotation.PreAuth;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 前端控制器
 * 宠物服务预约分类表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/uzPetServiceCategory")
@Api(value = "UzPetServiceCategory", tags = "宠物服务预约分类表")
@PreAuth(replace = "uzPetServiceCategory:")
public class UzPetServiceCategoryController extends SuperController<UzPetServiceCategoryService, Long, UzPetServiceCategory, UzPetServiceCategoryPageDTO, UzPetServiceCategorySaveDTO, UzPetServiceCategoryUpdateDTO> {

    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list){
        List<UzPetServiceCategory> uzPetServiceCategoryList = list.stream().map((map) -> {
            UzPetServiceCategory uzPetServiceCategory = UzPetServiceCategory.builder().build();
            //TODO 请在这里完成转换
            return uzPetServiceCategory;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(uzPetServiceCategoryList));
    }
}
