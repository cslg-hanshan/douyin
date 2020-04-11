package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.ShortVideoService;
import com.h2sj.douyin.domain.entity.ShortVideo;
import com.h2sj.douyin.domain.mapper.ShortVideoMapper;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ShortVideoServiceImpl extends ServiceImpl<ShortVideoMapper, ShortVideo> implements ShortVideoService {

    @Override
    public ShortVideo findDetailById(Serializable id) {
        // 获取详细信息
        ShortVideo shortVideo = baseMapper.selectById(id);
        shortVideo.setSvViewtimes(shortVideo.getSvViewtimes() + 1);
        baseMapper.updateById(shortVideo);
        return shortVideo;
    }
}
