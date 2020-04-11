package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@TableName(value = "db_role")
@Entity
@Table(name = "db_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 607913992267570135L;
    @TableId(value = "r_id",type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long rId;

    @TableField(value = "r_name")
    @Column(name = "r_name")
    private String rName;

    @TableField(value = "r_createdate")
    @Column(name = "r_createdate")
    private String rCreatedate;
}
