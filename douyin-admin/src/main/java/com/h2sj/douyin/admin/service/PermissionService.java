package com.h2sj.douyin.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.h2sj.douyin.domain.entity.Permission;

import java.util.List;

public interface PermissionService extends IService<Permission> {

    public List<Permission> findListByRoleId(Long id);
}
