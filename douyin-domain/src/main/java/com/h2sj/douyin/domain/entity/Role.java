package com.h2sj.douyin.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "db_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 607913992267570135L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long rId;

    @Column(name = "r_name")
    private String rName;

    @Column(name = "r_createdate",columnDefinition = "timestamp")
    private String rCreatedate;
}
