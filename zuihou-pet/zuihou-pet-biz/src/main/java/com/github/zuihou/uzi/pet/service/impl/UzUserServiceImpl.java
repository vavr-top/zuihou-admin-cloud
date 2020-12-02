package com.github.zuihou.uzi.pet.service.impl;


import com.github.zuihou.uzi.pet.dao.UzUserMapper;
import com.github.zuihou.uzi.pet.entity.UzUser;
import com.github.zuihou.uzi.pet.service.UzUserService;
import com.github.zuihou.base.service.SuperServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 用户表
 * </p>
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Slf4j
@Service

public class UzUserServiceImpl extends SuperServiceImpl<UzUserMapper, UzUser> implements UzUserService {
}
