package com.h2sj.douyin.admin.service;


import com.h2sj.douyin.domain.entity.VideoComment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VideoCommentService {
    public VideoComment save(VideoComment object);

    public void delete(VideoComment object);

    public void deleteById(Long id);

    public VideoComment update(VideoComment object);

    public VideoComment findOne(VideoComment object);

    public VideoComment findOneById(Long id);

    public List<VideoComment> findList(VideoComment object);

    public Page<VideoComment> findPages(String keyword, Integer page, Integer limit, String span);
}
