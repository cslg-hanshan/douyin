package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@TableName(value = "db_role_to_permission")
@Entity
@Table(name = "db_role_to_permission")
public class RoleToPermission implements Serializable {

    private static final long serialVersionUID = 713967606395229104L;
    @TableId(value = "rp_id",type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rp_id")
    private Long rpId;

    @TableField(value = "r_id")
    @Column(name = "r_id")
    private Long rId;

    @TableField(value = "p_id")
    @Column(name = "p_id")
    private Long pId;
}
