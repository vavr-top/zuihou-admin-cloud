package com.github.zuihou.uzi.pet.controller;

import com.github.zuihou.uzi.pet.entity.UzPetCategory;
import com.github.zuihou.uzi.pet.dto.UzPetCategorySaveDTO;
import com.github.zuihou.uzi.pet.dto.UzPetCategoryUpdateDTO;
import com.github.zuihou.uzi.pet.dto.UzPetCategoryPageDTO;
import com.github.zuihou.uzi.pet.service.UzPetCategoryService;
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
 * 宠物品种表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/uzPetCategory")
@Api(value = "UzPetCategory", tags = "宠物品种表")
@PreAuth(replace = "uzPetCategory:")
public class UzPetCategoryController extends SuperController<UzPetCategoryService, Long, UzPetCategory, UzPetCategoryPageDTO, UzPetCategorySaveDTO, UzPetCategoryUpdateDTO> {

    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list){
        List<UzPetCategory> uzPetCategoryList = list.stream().map((map) -> {
            UzPetCategory uzPetCategory = UzPetCategory.builder().build();
            //TODO 请在这里完成转换
            return uzPetCategory;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(uzPetCategoryList));
    }
}
