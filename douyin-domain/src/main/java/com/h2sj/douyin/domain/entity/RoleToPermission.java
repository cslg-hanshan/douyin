package com.h2sj.douyin.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "db_role_to_permission")
public class RoleToPermission implements Serializable {

    private static final long serialVersionUID = 713967606395229104L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rp_id")
    private Long rpId;

    @Column(name = "r_id")
    private Long rId;

    @Column(name = "p_id")
    private Long pId;
}
