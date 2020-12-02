package com.github.zuihou.uzi.pet.controller;

import com.github.zuihou.uzi.pet.entity.UzPet;
import com.github.zuihou.uzi.pet.dto.UzPetSaveDTO;
import com.github.zuihou.uzi.pet.dto.UzPetUpdateDTO;
import com.github.zuihou.uzi.pet.dto.UzPetPageDTO;
import com.github.zuihou.uzi.pet.service.UzPetService;
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
 * 宠物码
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/uzPet")
@Api(value = "UzPet", tags = "宠物码")
@PreAuth(replace = "uzPet:")
public class UzPetController extends SuperController<UzPetService, Long, UzPet, UzPetPageDTO, UzPetSaveDTO, UzPetUpdateDTO> {

    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list){
        List<UzPet> uzPetList = list.stream().map((map) -> {
            UzPet uzPet = UzPet.builder().build();
            //TODO 请在这里完成转换
            return uzPet;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(uzPetList));
    }
}
