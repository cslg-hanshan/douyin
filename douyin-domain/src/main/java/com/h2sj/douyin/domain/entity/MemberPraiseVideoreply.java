package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@TableName(value = "db_member_praise_videoreply")
@Entity
@Table(name = "db_member_praise_videoreply")
public class MemberPraiseVideoreply implements Serializable {

    private static final long serialVersionUID = -2061626738358741435L;

    @TableId(type = IdType.AUTO,value = "mpv_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mpv_id")
    private Long mpvId;

    @TableField(value = "m_id")
    @Column(name = "m_id")
    private Long mId;

    @TableField(value = "vp_id")
    @Column(name = "vp_id")
    private Long vpId;

    @TableField(value = "mpv_createdate")
    @Column(name = "mpv_createdate")
    private String mpvCreatedate;
}
