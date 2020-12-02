package com.github.zuihou.uzi.pet.service.impl;


import com.github.zuihou.uzi.pet.dao.UzQrcodeMapper;
import com.github.zuihou.uzi.pet.entity.UzQrcode;
import com.github.zuihou.uzi.pet.service.UzQrcodeService;
import com.github.zuihou.base.service.SuperServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 二维码主表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Service

public class UzQrcodeServiceImpl extends SuperServiceImpl<UzQrcodeMapper, UzQrcode> implements UzQrcodeService {
}
