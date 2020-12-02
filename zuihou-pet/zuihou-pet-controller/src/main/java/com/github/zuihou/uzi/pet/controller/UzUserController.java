package com.github.zuihou.uzi.pet.controller;

import com.github.zuihou.uzi.pet.entity.UzUser;
import com.github.zuihou.uzi.pet.dto.UzUserSaveDTO;
import com.github.zuihou.uzi.pet.dto.UzUserUpdateDTO;
import com.github.zuihou.uzi.pet.dto.UzUserPageDTO;
import com.github.zuihou.uzi.pet.service.UzUserService;
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
 * 用户表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/uzUser")
@Api(value = "UzUser", tags = "用户表")
@PreAuth(replace = "uzUser:")
public class UzUserController extends SuperController<UzUserService, Long, UzUser, UzUserPageDTO, UzUserSaveDTO, UzUserUpdateDTO> {

    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list){
        List<UzUser> uzUserList = list.stream().map((map) -> {
            UzUser uzUser = UzUser.builder().build();
            //TODO 请在这里完成转换
            return uzUser;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(uzUserList));
    }
}
