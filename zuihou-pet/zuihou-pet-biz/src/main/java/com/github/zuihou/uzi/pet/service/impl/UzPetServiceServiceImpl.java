package com.github.zuihou.uzi.pet.service.impl;


import com.github.zuihou.uzi.pet.dao.UzPetServiceMapper;
import com.github.zuihou.uzi.pet.entity.UzPetService;
import com.github.zuihou.uzi.pet.service.UzPetServiceService;
import com.github.zuihou.base.service.SuperServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 宠物服务预约表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Service

public class UzPetServiceServiceImpl extends SuperServiceImpl<UzPetServiceMapper, UzPetService> implements UzPetServiceService {
}
