package com.h2sj.douyin.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@TableName(value = "db_member")
@Entity
@Table(name = "db_member")
public class Member implements Serializable {

    private static final long serialVersionUID = -568236713372957034L;
    @TableId(type = IdType.AUTO,value = "m_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private Long mId;

    @TableField(value = "m_username")
    @Column(name = "m_username",nullable = false,unique = true)
    private String mUsername;

    @JSONField(serialize = false)
    @TableField(value = "m_password")
    @Column(name = "m_password")
    private String mPassword;

    @TableField(value = "m_Gender")
    @Column(name = "m_Gender")
    private String mGender;

    @TableField(value = "m_portrait")
    @Column(name = "m_portrait")
    private String mPortrait;

    @TableField(value = "m_birthday")
    @Column(name = "m_birthday")
    private String mBirthday;

    @TableField(value = "m_email")
    @Column(name = "m_email")
    private String mEmail;

    @TableField(value = "m_phone")
    @Column(name = "m_phone")
    private String mPhone;

    @TableField(value = "r_id")
    @Column(name = "r_id")
    private Long rId;
}
