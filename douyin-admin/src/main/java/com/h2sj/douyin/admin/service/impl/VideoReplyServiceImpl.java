package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.VideoReplyService;
import com.h2sj.douyin.domain.entity.VideoReply;
import com.h2sj.douyin.domain.mapper.VideoReplyMapper;
import org.springframework.stereotype.Service;

@Service
public class VideoReplyServiceImpl extends ServiceImpl<VideoReplyMapper, VideoReply> implements VideoReplyService {
}
