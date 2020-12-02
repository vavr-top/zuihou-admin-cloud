package com.github.zuihou.uzi.pet.service.impl;


import com.github.zuihou.uzi.pet.dao.UzPetServiceCategoryMapper;
import com.github.zuihou.uzi.pet.entity.UzPetServiceCategory;
import com.github.zuihou.uzi.pet.service.UzPetServiceCategoryService;
import com.github.zuihou.base.service.SuperServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 宠物服务预约分类表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Service

public class UzPetServiceCategoryServiceImpl extends SuperServiceImpl<UzPetServiceCategoryMapper, UzPetServiceCategory> implements UzPetServiceCategoryService {
}
