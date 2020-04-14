package com.h2sj.douyin.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h2sj.douyin.admin.service.MemberService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.Member;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@ApiResponses({@ApiResponse(code = 200,message = "success",response = Result.class)})
@Api
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder encoder;

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(notes = "添加Member",value = "addMember")
    @PostMapping(value = "/member",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody Member member){
        try {
            member.setMPassword(encoder.encode(member.getMPassword()));
            memberService.save(member);
            return Result.success();
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLINSERTERROR);
        }
    }

    @ApiOperation(notes = "删除Member",value = "deleteMember")
    @DeleteMapping(value = "/member/{id}",produces = "application/json; charset=utf-8")
    public Result delete(@PathVariable("id") Long id){
        try {
            memberService.removeById(id);
            return Result.success();
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @ApiOperation(notes = "修改Member",value = "updateMember")
    @PutMapping(value = "/member",produces = "application/json; charset=utf-8")
    public Result update(@RequestBody Member member){
        try {
            memberService.updateById(member);
            return Result.success();
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

    @PreAuthorize("hasAnyAuthority('getMember')")
    @ApiOperation(notes = "获取Member",value = "getMember")
    @GetMapping(value = "/member/{id}",produces = "application/json; charset=utf-8")
    public Result findOne(@PathVariable("id") Long id){
        try {
            Member member = memberService.getById(id);
            return Result.success(member);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

    @ApiOperation(notes = "获取Member页",value = "getMemberPages")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword",value = "用户名模糊匹配",required = false,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "page",value = "页码",required = false,dataType = "Integer",paramType = "query",defaultValue = "1"),
            @ApiImplicitParam(name = "limit",value = "每页个数",required = false,dataType = "Integer",paramType = "query",defaultValue = "20"),
            @ApiImplicitParam(name = "span",value = "时间范围",required = false,dataType = "String",paramType = "query",example = "2020-4-14 14:54:10,2020-4-14 14:56:20")
    })
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
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }
}
