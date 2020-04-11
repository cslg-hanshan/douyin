package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.PermissionService;
import com.h2sj.douyin.domain.entity.Permission;
import com.h2sj.douyin.domain.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired(required = false)
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findListByRoleId(Long id) {
        return permissionMapper.findListByRoleId(id);
    }
}
