package com.h2sj.douyin.domain.repository;

import com.h2sj.douyin.domain.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long>, JpaSpecificationExecutor<Permission> {

    @Query(nativeQuery = true,value = "select p_id,p_name,_p_url,p_description from db_permission where p_id in " +
            "(select p_id from db_role_to_permission where r_id = :id)")
    public List<Permission> findListByRid(@Param("id") Long id);
}
