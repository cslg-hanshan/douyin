package com.h2sj.douyin.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.h2sj.douyin.domain.entity.ShortVideo;

import java.io.Serializable;

public interface ShortVideoService extends IService<ShortVideo> {

    public ShortVideo findDetailById(Serializable id);
}
