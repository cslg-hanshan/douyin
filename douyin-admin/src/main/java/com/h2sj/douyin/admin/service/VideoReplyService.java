package com.h2sj.douyin.admin.service;


import com.h2sj.douyin.domain.entity.VideoReply;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VideoReplyService {
    public VideoReply save(VideoReply object);

    public void delete(VideoReply object);

    public void deleteById(Long id);

    public VideoReply update(VideoReply object);

    public VideoReply findOne(VideoReply object);

    public VideoReply findOneById(Long id);

    public List<VideoReply> findList(VideoReply object);

    public Page<VideoReply> findPages(String keyword, Integer page, Integer limit, String span);
}
