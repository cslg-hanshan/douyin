package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.VideoCommentService;
import com.h2sj.douyin.domain.entity.VideoComment;
import com.h2sj.douyin.domain.mapper.VideoCommentMapper;
import org.springframework.stereotype.Service;

@Service
public class VideoCommentServiceImpl extends ServiceImpl<VideoCommentMapper, VideoComment> implements VideoCommentService {
}
