package com.github.zuihou.uzi.pet.controller;

import com.github.zuihou.uzi.pet.entity.UzQrcode;
import com.github.zuihou.uzi.pet.dto.UzQrcodeSaveDTO;
import com.github.zuihou.uzi.pet.dto.UzQrcodeUpdateDTO;
import com.github.zuihou.uzi.pet.dto.UzQrcodePageDTO;
import com.github.zuihou.uzi.pet.service.UzQrcodeService;
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
 * 二维码主表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/uzQrcode")
@Api(value = "UzQrcode", tags = "二维码主表")
@PreAuth(replace = "uzQrcode:")
public class UzQrcodeController extends SuperController<UzQrcodeService, Long, UzQrcode, UzQrcodePageDTO, UzQrcodeSaveDTO, UzQrcodeUpdateDTO> {

    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list){
        List<UzQrcode> uzQrcodeList = list.stream().map((map) -> {
            UzQrcode uzQrcode = UzQrcode.builder().build();
            //TODO 请在这里完成转换
            return uzQrcode;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(uzQrcodeList));
    }
}
