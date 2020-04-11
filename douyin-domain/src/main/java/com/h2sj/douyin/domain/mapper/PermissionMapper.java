package com.h2sj.douyin.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.h2sj.douyin.domain.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    @Select(value = "select p_id,p_name,p_url,p_description from db_permission where p_id in " +
            "(select p_id from db_role_to_permission where r_id=#{id})")
    public List<Permission> findListByRoleId(@Param("id") Long id);
}
