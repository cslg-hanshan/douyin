package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "db_member")
public class Member implements Serializable {

    private static final long serialVersionUID = -568236713372957034L;

    @TableId(value = "m_id",type = IdType.AUTO)
    private Long mId;

    @TableField(value = "m_username")
    private String mUsername;

    @TableField(value = "m_password")
    private String mPassword;

    @TableField(value = "m_Gender")
    private String mGender;

    @TableField(value = "m_portrait")
    private String mPortrait;

    @TableField(value = "m_birthday")
    private String mBirthday;

    @TableField(value = "m_email")
    private String mEmail;

    @TableField(value = "m_phone")
    private String mPhone;

    @TableField(value = "m_createdate")
    private String mCreatedate;

    @TableField(value = "role_id")
    private Long roleId;
}
