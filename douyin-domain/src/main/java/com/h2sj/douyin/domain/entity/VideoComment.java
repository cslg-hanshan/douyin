package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName(value = "db_videocomment")
public class VideoComment implements Serializable {

    private static final long serialVersionUID = -9129246514505792379L;

    @TableId(value = "vc_id",type = IdType.AUTO)
    private Long vcId;

    @TableField(value = "vc_content")
    private String vcContent;

    @TableField(value = "vc_createdate")
    private String vcCreatedate;

    @TableField(value = "member_id")
    private Long memberId;

    @TableField(value = "shortvideo_id")
    private Long shortvideoId;
}
