package com.h2sj.douyin.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.h2sj.douyin.domain.entity.ShortVideo;

public interface ShortVideoService extends IService<ShortVideo> {
    public Page<ShortVideo> findPages(String keyword, Integer page, Integer limit, String span);
}
