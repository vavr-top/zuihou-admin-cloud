package com.github.zuihou.uzi.pet.service.impl;


import com.github.zuihou.uzi.pet.dao.UzPetMapper;
import com.github.zuihou.uzi.pet.entity.UzPet;
import com.github.zuihou.uzi.pet.service.UzPetService;
import com.github.zuihou.base.service.SuperServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 宠物码
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Service

public class UzPetServiceImpl extends SuperServiceImpl<UzPetMapper, UzPet> implements UzPetService {
}
