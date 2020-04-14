package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.RoleToPermissionService;
import com.h2sj.douyin.domain.entity.RoleToPermission;
import com.h2sj.douyin.domain.mapper.RoleToPermissionMapper;
import org.springframework.stereotype.Service;

@Service("roleToPermissionService")
public class RoleToPermissionServiceImpl extends ServiceImpl<RoleToPermissionMapper, RoleToPermission> implements RoleToPermissionService {
}
