package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@TableName(value = "db_videoreply")
@Entity
@Table(name = "db_videoreply")
public class VideoReply implements Serializable {
    private static final long serialVersionUID = 3566314262430798619L;

    @TableId(value = "vr_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vr_id")
    private Long vrId;

    @TableField(value = "vr_content")
    @Column(name = "vr_content")
    private String vrContent;

    @TableField(value = "vr_createdate")
    @Column(name = "vr_createdate")
    private String vrCreatedate;

    // Member
    @TableField(value = "vr_touser")
    @Column(name = "vr_touser")
    private Long vrTouser;

    // VideoComment
    @TableField(value = "vc_id")
    @Column(name = "vc_id")
    private Long vcId;

    // Member
    @TableField(value = "m_id")
    @Column(name = "m_id")
    private Long mId;

    // ShortVideo
    @TableField(value = "sv_id")
    @Column(name = "sv_id")
    private Long svId;
}
