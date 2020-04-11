package com.h2sj.douyin.admin.service;

import com.h2sj.douyin.domain.entity.Member;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MemberService {

    public Member save(Member object);

    public void delete(Member object);

    public void deleteById(Long id);

    public Member update(Member object);

    public Member findOne(Member object);

    public Member findOneById(Long id);

    public List<Member> findList(Member object);

    public Page<Member> findPages(String keyword,Integer page,Integer limit,String span);
}
