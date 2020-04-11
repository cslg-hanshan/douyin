package com.h2sj.douyin.admin.service;

import com.h2sj.douyin.domain.entity.Permission;
import org.springframework.data.domain.Page;

import java.util.List;


public interface PermissionService {
    public Permission save(Permission object);

    public void delete(Permission object);

    public void deleteById(Long id);

    public Permission update(Permission object);

    public Permission findOne(Permission object);

    public Permission findOneById(Long id);

    public List<Permission> findList();

    public List<Permission> findListByRid(Long id);
}
