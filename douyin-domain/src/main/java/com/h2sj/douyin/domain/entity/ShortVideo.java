package com.h2sj.douyin.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "db_shortvideo")
public class ShortVideo implements Serializable {

    private static final long serialVersionUID = 3926536524178599106L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sv_id")
    private Long svId;

    @Column(name = "sv_title")
    private String svTitle;

    @Column(name = "sv_createdate",columnDefinition = "timestamp")
    private String svCreatedate;

    @Column(name = "sv_url")
    private String svUrl;

    @Column(name = "sv_viewtimes")
    private Long svViewtimes;

    @Column(name = "m_id")
    private Long mId;
}
