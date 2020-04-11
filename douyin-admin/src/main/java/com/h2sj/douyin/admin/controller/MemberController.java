package com.h2sj.douyin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h2sj.douyin.admin.controller.base.BaseController;
import com.h2sj.douyin.admin.service.MemberService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class MemberController implements BaseController<Member> {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/member",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody Member member){
        try {
            member.setMPassword(encoder.encode(member.getMPassword()));
            if (memberService.save(member)){
                return Result.success();
            }else {
                return Result.failed(ResultCode.SQLINSERTERROR);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLINSERTERROR);
        }
    }

    @DeleteMapping(value = "/member/{id}",produces = "application/json; charset=utf-8")
    public Result delete(@PathVariable("id") Serializable id){
        try {
            if (memberService.removeById(id)) {
                return Result.success();
            }else {
                return Result.failed(ResultCode.SQLDELETEERROR);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/member",produces = "application/json; charset=utf-8")
    public Result update(@RequestBody Member member){
        try {
            member.setMPassword(encoder.encode(member.getMPassword()));
            UpdateWrapper<Member> wrapper = new UpdateWrapper<>();
            wrapper.lambda().eq(Member::getMId,member.getMId());

            if (memberService.update(member,wrapper)){
                return Result.success();
            }else {
                return Result.failed(ResultCode.SQLUPDATEERROR);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

//    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/member/{id}",produces = "application/json; charset=utf-8")
    public Result findOne(@PathVariable("id") Serializable id){
        try {
            Member member = memberService.getById(id);
            return Result.success(member);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }

    }

    @GetMapping(value = "/members",produces = "application/json; charset=utf-8")
    public Result findPages(
            @RequestParam(value = "keyword",required = false) String keyword,
            @RequestParam(value = "page",required = false,defaultValue = "1") Long page,
            @RequestParam(value = "limit",required = false,defaultValue = "20") Long limit,
            @RequestParam(value = "orderby",required = false) String orderby
    ){
        try {
            Page<Member> pager = new Page<>(page,limit);
            QueryWrapper<Member> wrapper = new QueryWrapper<>();
            if (orderby != null){
                String[] split = orderby.split(",");
                if (split[1].toLowerCase().equals("desc"))
                    wrapper.orderByDesc(split[0]);
                else
                    wrapper.orderByAsc(split[0]);
            }
            if (keyword != null)
                wrapper.likeRight("m_username",keyword);
            Page<Member> pages = memberService.page(pager, wrapper);
            return Result.success(pages);
        } catch (Exception ex) {
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

    @GetMapping(value = "/member")
    public Result findOneByUsername(@RequestParam(value = "username") String username){
        try {
            if (username == null)
                return Result.failed(ResultCode.SQLSELECTERROR);
            QueryWrapper<Member> memberQueryWrapper = new QueryWrapper<>();
            memberQueryWrapper.lambda().eq(Member::getMUsername,username);
            Member member = memberService.getOne(memberQueryWrapper);
            return Result.success(member);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }
}
