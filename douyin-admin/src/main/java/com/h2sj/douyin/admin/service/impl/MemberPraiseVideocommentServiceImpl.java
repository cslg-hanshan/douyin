package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.MemberPraiseVideocommentService;
import com.h2sj.douyin.domain.entity.MemberPraiseVideocomment;
import com.h2sj.douyin.domain.mapper.MemberPraiseVideocommentMapper;
import org.springframework.stereotype.Service;

@Service("memberPraiseVideocommentService")
public class MemberPraiseVideocommentServiceImpl extends ServiceImpl<MemberPraiseVideocommentMapper,MemberPraiseVideocomment> implements MemberPraiseVideocommentService {
}
