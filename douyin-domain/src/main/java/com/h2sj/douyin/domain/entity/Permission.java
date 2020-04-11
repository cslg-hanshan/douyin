package com.h2sj.douyin.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "db_permission")
public class Permission implements Serializable{

    private static final long serialVersionUID = 7780916238946755137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long pId;

    @Column(name = "p_name")
    private String pName;

    @Column(name = "p_url")
    private String pUrl;

    @Column(name = "p_description")
    private String pDescription;

    @Column(name = "p_createdate",columnDefinition = "timestamp")
    private String pCreatedate;
}
