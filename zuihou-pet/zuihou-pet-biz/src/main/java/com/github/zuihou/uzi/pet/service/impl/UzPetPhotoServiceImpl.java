package com.github.zuihou.uzi.pet.service.impl;


import com.github.zuihou.uzi.pet.dao.UzPetPhotoMapper;
import com.github.zuihou.uzi.pet.entity.UzPetPhoto;
import com.github.zuihou.uzi.pet.service.UzPetPhotoService;
import com.github.zuihou.base.service.SuperServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 宠物相册表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Service

public class UzPetPhotoServiceImpl extends SuperServiceImpl<UzPetPhotoMapper, UzPetPhoto> implements UzPetPhotoService {
}
