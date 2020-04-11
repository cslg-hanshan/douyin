package com.h2sj.douyin.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "db_member_praise_videoreply")
public class MemberPraiseVideoreply implements Serializable {

    private static final long serialVersionUID = -2061626738358741435L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mpv_id")
    private Long mpvId;

    @Column(name = "m_id")
    private Long mId;

    @Column(name = "vp_id")
    private Long vpId;

    @Column(name = "mpv_createdate",columnDefinition = "timestamp")
    private String mpvCreatedate;
}
