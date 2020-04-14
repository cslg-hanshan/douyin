package com.h2sj.douyin.admin.security.userdetails;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.h2sj.douyin.admin.service.MemberService;
import com.h2sj.douyin.admin.service.PermissionService;
import com.h2sj.douyin.admin.service.RoleService;
import com.h2sj.douyin.admin.service.RoleToPermissionService;
import com.h2sj.douyin.admin.service.impl.MemberServiceImpl;
import com.h2sj.douyin.admin.service.impl.PermissionServiceImpl;
import com.h2sj.douyin.admin.service.impl.RoleServiceImpl;
import com.h2sj.douyin.admin.service.impl.RoleToPermissionServiceImpl;
import com.h2sj.douyin.domain.entity.Member;
import com.h2sj.douyin.domain.entity.Permission;
import com.h2sj.douyin.domain.entity.Role;
import com.h2sj.douyin.domain.entity.RoleToPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("memberService")
    private MemberService memberService;

    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    @Autowired
    @Qualifier("permissionService")
    private PermissionService permissionService;

    @Autowired
    @Qualifier("roleToPermissionService")
    private RoleToPermissionService rtpService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            QueryWrapper<Member> memberQueryWrapper = new QueryWrapper<>();
            memberQueryWrapper.lambda().eq(Member::getMUsername,s);
            Member member = memberService.getOne(memberQueryWrapper);

            //初始授权列表
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            if (member == null) throw new UsernameNotFoundException("username not found");
            if (member.getRoleId() == null)
                return User.builder().username(member.getMUsername()).password(member.getMPassword()).authorities(authorities).build();
            Role role = roleService.getById(member.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getRName()));

            QueryWrapper<RoleToPermission> roleToPermissionQueryWrapper = new QueryWrapper<>();
            roleToPermissionQueryWrapper.lambda().eq(RoleToPermission::getRoleId,role.getRId());
            List<RoleToPermission> rtpList = rtpService.list(roleToPermissionQueryWrapper);
            if (rtpList.size() != 0){
                for (RoleToPermission rtp:rtpList) {
                    Permission permission = permissionService.getById(rtp.getPermissionId());
                    authorities.add(new SimpleGrantedAuthority(permission.getPName()));
                }

            }
            return User.builder().username(member.getMUsername()).password(member.getMPassword()).authorities(authorities).build();
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new UsernameNotFoundException("username not found");
        }

    }
}
