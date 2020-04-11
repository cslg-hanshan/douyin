package com.h2sj.douyin.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "db_videocomment")
public class VideoComment implements Serializable {

    private static final long serialVersionUID = -9129246514505792379L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vc_id")
    private Long vcId;

    @Column(name = "vc_content")
    private String vcContent;

    @Column(name = "vc_createdate",columnDefinition = "timestamp")
    private String vcCreatedate;

    @Column(name = "m_id")
    private Long mId;

    @Column(name = "sv_id")
    private Long svId;
}
