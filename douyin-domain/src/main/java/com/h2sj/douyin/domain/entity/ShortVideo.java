package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName(value = "db_shortvideo")
public class ShortVideo implements Serializable {

    private static final long serialVersionUID = 3926536524178599106L;

    @TableId(value = "sv_id",type = IdType.AUTO)
    private Long svId;

    @TableField(value = "sv_title")
    private String svTitle;

    @TableField(value = "sv_createdate")
    private String svCreatedate;

    @TableField(value = "sv_url")
    private String svUrl;

    @TableField(value = "sv_viewtimes")
    private Long svViewtimes;

    @TableField(value = "member_id")
    private Long memberId;
}
