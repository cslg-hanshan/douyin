package com.h2sj.douyin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@TableName(value = "db_shortvideo")
@Entity
@Table(name = "db_shortvideo")
public class ShortVideo implements Serializable {

    private static final long serialVersionUID = 3926536524178599106L;
    @TableId(value = "sv_id",type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sv_id")
    private Long svId;

    @TableField(value = "sv_title")
    @Column(name = "sv_title")
    private String svTitle;

    @TableField(value = "sv_createdate")
    @Column(name = "sv_createdate")
    private String svCreatedate;

    @TableField(value = "sv_url")
    @Column(name = "sv_url")
    private String svUrl;

    @TableField(value = "sv_viewtimes")
    @Column(name = "sv_viewtimes")
    private Long svViewtimes;

    @TableField(value = "m_id")
    @Column(name = "m_id")
    private Long mId;
}
