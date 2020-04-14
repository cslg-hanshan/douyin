package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.VideoCommentService;
import com.h2sj.douyin.domain.entity.VideoComment;
import com.h2sj.douyin.domain.mapper.VideoCommentMapper;
import org.springframework.stereotype.Service;

@Service("videoCommentService")
public class VideoCommentServiceImpl extends ServiceImpl<VideoCommentMapper,VideoComment> implements VideoCommentService {
    @Override
    public Page<VideoComment> findPages(String keyword, Integer page, Integer limit, String span) {
        Page<VideoComment> pager = new Page<>(page,limit);
        QueryWrapper<VideoComment> queryWrapper = new QueryWrapper<>();
        if (keyword != null) {
            queryWrapper.lambda().likeRight(VideoComment::getVcContent,keyword);
        }
        if (span != null) {
            String[] spans = span.split(",");
            queryWrapper.lambda().between(VideoComment::getVcCreatedate,spans[0],spans[1]);
        }
        return this.baseMapper.selectPage(pager, queryWrapper);
    }
}
