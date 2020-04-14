package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "db_member_praise_videoreply")
public class MemberPraiseVideoreply implements Serializable {

    private static final long serialVersionUID = -2061626738358741435L;

    @TableId(value = "mpv_id",type = IdType.AUTO)
    private Long mpvId;

    @TableField(value = "member_id")
    private Long memberId;

    @TableField(value = "videoreply_id")
    private Long videoreplyId;

    @TableField(value = "mpv_createdate")
    private String mpvCreatedate;
}
