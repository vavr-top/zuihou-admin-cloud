package com.github.zuihou.uzi.pet.service.impl;


import com.github.zuihou.uzi.pet.dao.UzPetCategoryMapper;
import com.github.zuihou.uzi.pet.entity.UzPetCategory;
import com.github.zuihou.uzi.pet.service.UzPetCategoryService;
import com.github.zuihou.base.service.SuperServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 宠物品种表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Service

public class UzPetCategoryServiceImpl extends SuperServiceImpl<UzPetCategoryMapper, UzPetCategory> implements UzPetCategoryService {
}
