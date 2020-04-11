package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@TableName(value = "db_member_praisee_videocomment")
@Entity
@Table(name = "db_member_praisee_videocomment")
public class MemberPraiseVideocomment implements Serializable {

    private static final long serialVersionUID = -5122623729558916847L;

    @TableId(value = "mpv_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mpv_id")
    private Long mpvId;

    @TableField(value = "m_id")
    @Column(name = "m_id")
    private Long mId;

    @TableField(value = "vc_id")
    @Column(name = "vc_id")
    private Long vcId;

    @TableField(value = "mpv_createdate")
    @Column(name = "mpv_createdate")
    private String mpvCreatedate;
}
