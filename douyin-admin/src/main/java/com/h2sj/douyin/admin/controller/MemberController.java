package com.h2sj.douyin.admin.controller;

import com.h2sj.douyin.admin.service.MemberService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/member",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody Member member){
        try {
            member.setMPassword(encoder.encode(member.getMPassword()));
            if (memberService.save(member) != null){
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
    public Result delete(@PathVariable("id") Long id){
        try {
            memberService.deleteById(id);
            return Result.success();
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/member",produces = "application/json; charset=utf-8")
    public Result update(@RequestBody Member member){
        try {
            if (memberService.update(member) != null){
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
    public Result findOne(@PathVariable("id") Long id){
        try {
            Member member = memberService.findOneById(id);
            return Result.success(member);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }

    }

    @GetMapping(value = "/members",produces = "application/json; charset=utf-8")
    public Result findPages(
            @RequestParam(value = "keyword",required = false) String keyword,
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(value = "limit",required = false,defaultValue = "20") Integer limit,
            @RequestParam(value = "span",required = false) String span
    ){
        try {
            Page<Member> pages = memberService.findPages(keyword, page, limit, span);
            return Result.success(pages);
        } catch (Exception ex) {
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }
}
