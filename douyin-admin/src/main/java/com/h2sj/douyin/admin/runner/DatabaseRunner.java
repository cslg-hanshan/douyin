package com.h2sj.douyin.admin.runner;

import com.h2sj.douyin.admin.service.MemberService;
import com.h2sj.douyin.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements ApplicationRunner {

    @Autowired
    private MemberService memberService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Custom Runner...");
        Member member = new Member();
        member.setMUsername("admin");
        member.setMPassword("123456");
        memberService.save(member);
    }
}
