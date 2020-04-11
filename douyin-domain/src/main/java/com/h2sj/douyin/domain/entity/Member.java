package com.h2sj.douyin.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "db_member")
public class Member implements Serializable {

    private static final long serialVersionUID = -568236713372957034L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private Long mId;

    @Column(name = "m_username",nullable = false,unique = true)
    private String mUsername;

    @Column(name = "m_password",nullable = false)
    private String mPassword;

    @Column(name = "m_Gender")
    private String mGender;

    @Column(name = "m_portrait")
    private String mPortrait;

    @Column(name = "m_birthday",columnDefinition = "timestamp")
    private String mBirthday;

    @Column(name = "m_email")
    private String mEmail;

    @Column(name = "m_phone")
    private String mPhone;

    @Column(name = "r_id")
    private Long rId;

    @Column(name = "m_createdate",columnDefinition = "timestamp")
    private String mCreatedate;
}
