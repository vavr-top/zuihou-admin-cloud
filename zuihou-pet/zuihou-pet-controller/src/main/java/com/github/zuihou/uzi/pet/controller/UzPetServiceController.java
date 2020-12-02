package com.github.zuihou.uzi.pet.controller;

import com.github.zuihou.uzi.pet.entity.UzPetService;
import com.github.zuihou.uzi.pet.dto.UzPetServiceSaveDTO;
import com.github.zuihou.uzi.pet.dto.UzPetServiceUpdateDTO;
import com.github.zuihou.uzi.pet.dto.UzPetServicePageDTO;
import com.github.zuihou.uzi.pet.service.UzPetServiceService;
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
 * 宠物服务预约表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/uzPetService")
@Api(value = "UzPetService", tags = "宠物服务预约表")
@PreAuth(replace = "uzPetService:")
public class UzPetServiceController extends SuperController<UzPetServiceService, Long, UzPetService, UzPetServicePageDTO, UzPetServiceSaveDTO, UzPetServiceUpdateDTO> {

    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list){
        List<UzPetService> uzPetServiceList = list.stream().map((map) -> {
            UzPetService uzPetService = UzPetService.builder().build();
            //TODO 请在这里完成转换
            return uzPetService;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(uzPetServiceList));
    }
}
