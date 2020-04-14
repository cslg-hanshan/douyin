package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.PermissionService;
import com.h2sj.douyin.domain.entity.Permission;
import com.h2sj.douyin.domain.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper,Permission> implements PermissionService {
}
