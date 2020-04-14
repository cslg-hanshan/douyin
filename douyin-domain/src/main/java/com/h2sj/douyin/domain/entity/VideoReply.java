package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName(value = "db_videoreply")
public class VideoReply implements Serializable {

    private static final long serialVersionUID = 3566314262430798619L;

    @TableId(value = "vr_id",type = IdType.AUTO)
    private Long vrId;

    @TableField(value = "vr_content")
    private String vrContent;

    @TableField(value = "vr_createdate")
    private String vrCreatedate;

    // Member
    @TableField(value = "touser_id")
    private Long touserId;

    // VideoComment
    @TableField(value = "videocomment_id")
    private Long videocommentId;

    // Member
    @TableField(value = "member_id")
    private Long memberId;
}
