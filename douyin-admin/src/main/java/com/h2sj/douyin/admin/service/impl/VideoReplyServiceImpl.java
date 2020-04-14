package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.VideoReplyService;
import com.h2sj.douyin.domain.entity.VideoReply;
import com.h2sj.douyin.domain.mapper.VideoReplyMapper;
import org.springframework.stereotype.Service;

@Service("videoReplyService")
public class VideoReplyServiceImpl extends ServiceImpl<VideoReplyMapper,VideoReply> implements VideoReplyService {
    @Override
    public Page<VideoReply> findPages(String keyword, Integer page, Integer limit, String span) {
        Page<VideoReply> pager = new Page<>(page,limit);
        QueryWrapper<VideoReply> queryWrapper = new QueryWrapper<>();
        if (keyword != null) {
            queryWrapper.lambda().likeRight(VideoReply::getVrContent,keyword);
        }
        if (span != null) {
            String[] spans = span.split(",");
            queryWrapper.lambda().between(VideoReply::getVrCreatedate,spans[0],spans[1]);
        }
        return this.baseMapper.selectPage(pager, queryWrapper);
    }
}
