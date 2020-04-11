package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@TableName(value = "db_permission")
@Entity
@Table(name = "db_permission")
public class Permission implements Serializable{

    private static final long serialVersionUID = 7780916238946755137L;
    @TableId(value = "p_id",type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long pId;

    @TableField(value = "p_name")
    @Column(name = "p_name")
    private String pName;

    @TableField(value = "p_url")
    @Column(name = "p_url")
    private String pUrl;

    @TableField(value = "p_description")
    @Column(name = "p_description")
    private String pDescription;
}
