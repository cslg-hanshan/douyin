package com.h2sj.douyin.admin.security.userdetails;

import com.h2sj.douyin.admin.service.MemberService;
import com.h2sj.douyin.admin.service.PermissionService;
import com.h2sj.douyin.admin.service.RoleService;
import com.h2sj.douyin.domain.entity.Member;
import com.h2sj.douyin.domain.entity.Permission;
import com.h2sj.douyin.domain.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            Member memberExample = new Member();
            memberExample.setMUsername(s);
            Member member = memberService.findOne(memberExample);

            //初始授权列表
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            if (member == null) throw new UsernameNotFoundException("username not found");
            if (member.getRId() == null)
                return User.builder().username(member.getMUsername()).password(member.getMPassword()).authorities(authorities).build();
            Role role = roleService.findOneById(member.getRId());
            authorities.add(new SimpleGrantedAuthority(role.getRName()));

            List<Permission> permissions = permissionService.findListByRid(role.getRId());
            for (Permission permission:permissions)
                authorities.add(new SimpleGrantedAuthority(permission.getPName()));

            return User.builder().username(member.getMUsername()).password(member.getMPassword()).authorities(authorities).build();
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new UsernameNotFoundException("username not found");
        }

    }
}
