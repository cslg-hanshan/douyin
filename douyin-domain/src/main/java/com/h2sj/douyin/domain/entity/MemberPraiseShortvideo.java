package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName(value = "db_member_praise_shortvideo")
public class MemberPraiseShortvideo implements Serializable {
    private static final long serialVersionUID = 5873110013200320893L;

    @TableId(value = "mpv_id",type = IdType.AUTO)
    private Long mpvId;

    // Member
    @TableField(value = "member_id")
    private Long memberId;

    // VideoReply
    @TableField(value = "videoreply_id")
    private Long videoreplyId;

    @TableField(value = "mpv_createdate")
    private String mpvCreatedate;
}
