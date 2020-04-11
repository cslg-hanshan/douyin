package com.h2sj.douyin.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "db_videoreply")
public class VideoReply implements Serializable {

    private static final long serialVersionUID = 3566314262430798619L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vr_id")
    private Long vrId;

    @Column(name = "vr_content")
    private String vrContent;

    @Column(name = "vr_createdate",columnDefinition = "timestamp")
    private String vrCreatedate;

    // Member
    @Column(name = "vr_touser")
    private Long vrTouser;

    // VideoComment
    @Column(name = "vc_id")
    private Long vcId;

    // Member
    @Column(name = "m_id")
    private Long mId;

    // ShortVideo
    @Column(name = "sv_id")
    private Long svId;
}
