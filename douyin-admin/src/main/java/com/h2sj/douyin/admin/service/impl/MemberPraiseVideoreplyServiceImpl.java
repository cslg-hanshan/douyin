package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.MemberPraiseVideoreplyService;
import com.h2sj.douyin.domain.entity.MemberPraiseVideoreply;
import com.h2sj.douyin.domain.mapper.MemberPraiseVideoreplyMapper;
import org.springframework.stereotype.Service;

@Service("memberPraiseVideoreplyService")
public class MemberPraiseVideoreplyServiceImpl extends ServiceImpl<MemberPraiseVideoreplyMapper,MemberPraiseVideoreply> implements MemberPraiseVideoreplyService {
}
