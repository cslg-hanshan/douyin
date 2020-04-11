package com.h2sj.douyin.admin.runner;

import com.h2sj.douyin.admin.service.impl.MemberServiceImpl;
import com.h2sj.douyin.admin.service.impl.RoleServiceImpl;
import com.h2sj.douyin.common.utils.DateUtils;
import com.h2sj.douyin.domain.entity.Member;
import com.h2sj.douyin.domain.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DatabaseRunner implements ApplicationRunner {

    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private RoleServiceImpl roleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Custom Runner...");
        Role role = new Role();
        role.setRName("ROLE_ADMIN");
        role.setRCreatedate(DateUtils.dateTimeToString(new Date()));
        Role rolesave = roleService.save(role);

        Member member = new Member();
        member.setMUsername("admin");
        member.setMPassword("123456");
        member.setRId(rolesave.getRId());
        memberService.save(member);
    }
}
