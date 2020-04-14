package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName(value = "db_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 607913992267570135L;

    @TableId(value = "r_id",type = IdType.AUTO)
    private Long rId;

    @TableField(value = "r_name")
    private String rName;

    @TableField(value = "r_createdate")
    private String rCreatedate;
}
