package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "db_role_to_permission")
public class RoleToPermission implements Serializable {

    private static final long serialVersionUID = 713967606395229104L;

    @TableField(value = "rp_id")
    private Long rpId;

    @TableField(value = "role_id")
    private Long roleId;

    @TableField(value = "permission_id")
    private Long permissionId;
}
