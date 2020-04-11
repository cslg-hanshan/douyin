package com.h2sj.douyin.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "db_member_praisee_videocomment")
public class MemberPraiseVideocomment implements Serializable {

    private static final long serialVersionUID = -5122623729558916847L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mpv_id")
    private Long mpvId;

    @Column(name = "m_id")
    private Long mId;

    @Column(name = "vc_id")
    private Long vcId;

    @Column(name = "mpv_createdate",columnDefinition = "timestamp")
    private String mpvCreatedate;
}
