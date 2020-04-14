package com.h2sj.douyin.admin.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.h2sj.douyin.domain.entity.VideoComment;

public interface VideoCommentService extends IService<VideoComment> {
    public Page<VideoComment> findPages(String keyword, Integer page, Integer limit, String span);
}
