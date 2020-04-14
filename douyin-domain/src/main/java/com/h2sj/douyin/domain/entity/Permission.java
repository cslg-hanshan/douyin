package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "db_permission")
public class Permission implements Serializable{

    private static final long serialVersionUID = 7780916238946755137L;

    @TableId(value = "p_id",type = IdType.AUTO)
    private Long pId;

    @TableField(value = "p_name")
    private String pName;

    @TableField(value = "p_url")
    private String pUrl;

    @TableField(value = "p_description")
    private String pDescription;

    @TableField(value = "p_createdate")
    private String pCreatedate;
}
