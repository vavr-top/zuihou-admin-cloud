package com.github.zuihou.uzi.pet.controller;

import com.github.zuihou.uzi.pet.entity.UzPetRecord;
import com.github.zuihou.uzi.pet.dto.UzPetRecordSaveDTO;
import com.github.zuihou.uzi.pet.dto.UzPetRecordUpdateDTO;
import com.github.zuihou.uzi.pet.dto.UzPetRecordPageDTO;
import com.github.zuihou.uzi.pet.service.UzPetRecordService;
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
 * 宠物记录表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/uzPetRecord")
@Api(value = "UzPetRecord", tags = "宠物记录表")
@PreAuth(replace = "uzPetRecord:")
public class UzPetRecordController extends SuperController<UzPetRecordService, Long, UzPetRecord, UzPetRecordPageDTO, UzPetRecordSaveDTO, UzPetRecordUpdateDTO> {

    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list){
        List<UzPetRecord> uzPetRecordList = list.stream().map((map) -> {
            UzPetRecord uzPetRecord = UzPetRecord.builder().build();
            //TODO 请在这里完成转换
            return uzPetRecord;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(uzPetRecordList));
    }
}
