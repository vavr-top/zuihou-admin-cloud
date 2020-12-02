package com.github.zuihou.uzi.pet.service.impl;


import com.github.zuihou.uzi.pet.dao.UzPetExpertMapper;
import com.github.zuihou.uzi.pet.entity.UzPetExpert;
import com.github.zuihou.uzi.pet.service.UzPetExpertService;
import com.github.zuihou.base.service.SuperServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 宠物专家表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Service

public class UzPetExpertServiceImpl extends SuperServiceImpl<UzPetExpertMapper, UzPetExpert> implements UzPetExpertService {
}
