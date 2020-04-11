package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@TableName(value = "db_videocomment")
@Entity
@Table(name = "db_videocomment")
public class VideoComment implements Serializable {

    private static final long serialVersionUID = -9129246514505792379L;
    @TableId(value = "vc_id",type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vc_id")
    private Long vcId;

    @TableField(value = "vc_content")
    @Column(name = "vc_content")
    private String vcContent;

    @TableField(value = "vc_createdate")
    @Column(name = "vc_createdate")
    private String vcCreatedate;

    @TableField(value = "m_id")
    @Column(name = "m_id")
    private Long mId;

    @TableField(value = "sv_id")
    @Column(name = "sv_id")
    private Long svId;
}
