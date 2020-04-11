package com.h2sj.douyin.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "db_member_praise_shortvideo")
public class MemberPraiseShortvideo implements Serializable {
    private static final long serialVersionUID = 5873110013200320893L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mpv_id")
    private Long mpvId;

    // Member
    @Column(name = "m_id")
    private Long mId;

    // VideoReply
    @Column(name = "vp_id")
    private Long vpId;

    @Column(name = "mpv_createdate",columnDefinition = "timestamp")
    private String mpvCreatedate;
}
