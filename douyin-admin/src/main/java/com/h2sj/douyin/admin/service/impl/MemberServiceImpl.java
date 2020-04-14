package com.h2sj.douyin.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h2sj.douyin.admin.service.MemberService;
import com.h2sj.douyin.domain.entity.Member;
import com.h2sj.douyin.domain.mapper.MemberMapper;
import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper,Member> implements MemberService {
    @Override
    public Page<Member> findPages(String keyword, Integer page, Integer limit, String span) {
        Page<Member> pager = new Page<>(page,limit);
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        if (keyword != null) {
            queryWrapper.lambda().likeRight(Member::getMUsername,keyword);
        }
        if (span != null) {
            String[] spans = span.split(",");
            queryWrapper.lambda().between(Member::getMCreatedate,spans[0],spans[1]);
        }
        return this.baseMapper.selectPage(pager, queryWrapper);
    }
}
