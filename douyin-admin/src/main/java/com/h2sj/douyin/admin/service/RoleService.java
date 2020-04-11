package com.h2sj.douyin.admin.service;


import com.h2sj.douyin.domain.entity.Role;

import java.util.List;

public interface RoleService {
    public Role save(Role object);

    public void delete(Role object);

    public void deleteById(Long id);

    public Role update(Role object);

    public Role findOne(Role object);

    public Role findOneById(Long id);

    public List<Role> findList();
}
