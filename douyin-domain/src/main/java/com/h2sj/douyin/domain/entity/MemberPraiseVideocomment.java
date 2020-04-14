package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "db_member_praisee_videocomment")
public class MemberPraiseVideocomment implements Serializable {

    private static final long serialVersionUID = -5122623729558916847L;

    @TableId(value = "mpv_id",type = IdType.AUTO)
    private Long mpvId;

    @TableField(value = "member_id")
    private Long memberId;

    @TableField(value = "videocomment_id")
    private Long videocommentId;

    @TableField(value = "mpv_createdate")
    private String mpvCreatedate;
}
