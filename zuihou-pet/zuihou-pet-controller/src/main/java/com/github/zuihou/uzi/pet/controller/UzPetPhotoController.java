package com.github.zuihou.uzi.pet.controller;

import com.github.zuihou.uzi.pet.entity.UzPetPhoto;
import com.github.zuihou.uzi.pet.dto.UzPetPhotoSaveDTO;
import com.github.zuihou.uzi.pet.dto.UzPetPhotoUpdateDTO;
import com.github.zuihou.uzi.pet.dto.UzPetPhotoPageDTO;
import com.github.zuihou.uzi.pet.service.UzPetPhotoService;
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
 * 宠物相册表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/uzPetPhoto")
@Api(value = "UzPetPhoto", tags = "宠物相册表")
@PreAuth(replace = "uzPetPhoto:")
public class UzPetPhotoController extends SuperController<UzPetPhotoService, Long, UzPetPhoto, UzPetPhotoPageDTO, UzPetPhotoSaveDTO, UzPetPhotoUpdateDTO> {

    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list){
        List<UzPetPhoto> uzPetPhotoList = list.stream().map((map) -> {
            UzPetPhoto uzPetPhoto = UzPetPhoto.builder().build();
            //TODO 请在这里完成转换
            return uzPetPhoto;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(uzPetPhotoList));
    }
}
