package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.ShortVideoService;
import com.h2sj.douyin.domain.entity.Member;
import com.h2sj.douyin.domain.entity.ShortVideo;
import com.h2sj.douyin.domain.mapper.ShortVideoMapper;
import org.springframework.stereotype.Service;

@Service("shortVideoService")
public class ShortVideoServiceImpl extends ServiceImpl<ShortVideoMapper,ShortVideo> implements ShortVideoService {

    @Override
    public Page<ShortVideo> findPages(String keyword, Integer page, Integer limit, String span) {
        Page<ShortVideo> pager = new Page<>(page,limit);
        QueryWrapper<ShortVideo> queryWrapper = new QueryWrapper<>();
        if (keyword != null) {
            queryWrapper.lambda().likeRight(ShortVideo::getSvTitle,keyword);
        }
        if (span != null) {
            String[] spans = span.split(",");
            queryWrapper.lambda().between(ShortVideo::getSvCreatedate,spans[0],spans[1]);
        }
        return this.baseMapper.selectPage(pager, queryWrapper);
    }

}
