package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.MemberPraiseShortvideoService;
import com.h2sj.douyin.domain.entity.MemberPraiseShortvideo;
import com.h2sj.douyin.domain.mapper.MemberPraiseShortvideoMapper;
import org.springframework.stereotype.Service;

@Service("memberPraiseShortvideoService")
public class MemberPraiseShortvideoServiceImpl extends ServiceImpl<MemberPraiseShortvideoMapper,MemberPraiseShortvideo> implements MemberPraiseShortvideoService {
}
