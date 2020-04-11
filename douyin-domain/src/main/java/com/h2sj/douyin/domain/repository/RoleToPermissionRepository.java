package com.h2sj.douyin.domain.repository;

import com.h2sj.douyin.domain.entity.RoleToPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleToPermissionRepository extends JpaRepository<RoleToPermission,Long>, JpaSpecificationExecutor<RoleToPermission> {
}
