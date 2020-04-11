package com.h2sj.douyin.admin.service;

import com.h2sj.douyin.domain.entity.ShortVideo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ShortVideoService {
    public ShortVideo save(ShortVideo object);

    public void delete(ShortVideo object);

    public void deleteById(Long id);

    public ShortVideo update(ShortVideo object);

    public ShortVideo findOne(ShortVideo object);

    public ShortVideo findOneById(Long id);

    public List<ShortVideo> findList(ShortVideo object);

    public Page<ShortVideo> findPages(String keyword, Integer page, Integer limit, String span);
}
