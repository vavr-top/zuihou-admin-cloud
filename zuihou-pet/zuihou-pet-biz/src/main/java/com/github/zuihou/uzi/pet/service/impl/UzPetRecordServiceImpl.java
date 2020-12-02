package com.github.zuihou.uzi.pet.service.impl;


import com.github.zuihou.uzi.pet.dao.UzPetRecordMapper;
import com.github.zuihou.uzi.pet.entity.UzPetRecord;
import com.github.zuihou.uzi.pet.service.UzPetRecordService;
import com.github.zuihou.base.service.SuperServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 宠物记录表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Service

public class UzPetRecordServiceImpl extends SuperServiceImpl<UzPetRecordMapper, UzPetRecord> implements UzPetRecordService {
}
