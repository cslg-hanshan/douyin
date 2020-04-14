package com.h2sj.douyin.admin.runner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.h2sj.douyin.admin.service.MemberService;
import com.h2sj.douyin.admin.service.PermissionService;
import com.h2sj.douyin.admin.service.RoleService;
import com.h2sj.douyin.admin.service.impl.MemberServiceImpl;
import com.h2sj.douyin.admin.service.impl.PermissionServiceImpl;
import com.h2sj.douyin.admin.service.impl.RoleServiceImpl;
import com.h2sj.douyin.common.utils.DateUtils;
import com.h2sj.douyin.domain.entity.Member;
import com.h2sj.douyin.domain.entity.Permission;
import com.h2sj.douyin.domain.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DatabaseRunner implements ApplicationRunner {

    @Autowired
    @Qualifier("memberService")
    private MemberService memberService;

    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    @Autowired
    @Qualifier("permissionService")
    private PermissionService permissionService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Custom Runner...");

        QueryWrapper<Role> roleQuery = new QueryWrapper<>();
        roleQuery.lambda().eq(Role::getRName, "ROLE_ADMIN");
        Role one = roleService.getOne(roleQuery);


        if (one == null) {
            Role role = new Role();
            role.setRName("ROLE_ADMIN");
            role.setRCreatedate(DateUtils.dateTimeToString(new Date()));
            roleService.save(role);
            QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
            roleQueryWrapper.lambda().eq(Role::getRName,"ROLE_ADMIN");
            Role saveRole = roleService.getOne(roleQueryWrapper);

            Member member = new Member();
            member.setMUsername("admin");
            member.setMPassword(encoder.encode("123456"));
            member.setRoleId(saveRole.getRId());
            memberService.save(member);
        }

    }

}
