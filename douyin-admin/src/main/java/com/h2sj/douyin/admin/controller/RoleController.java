package com.h2sj.douyin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h2sj.douyin.admin.controller.base.BaseController;
import com.h2sj.douyin.admin.service.RoleService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class RoleController implements BaseController<Role> {

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/role",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody Role role){
        try {
            if (roleService.save(role)){
                return Result.success();
            }else {
                return Result.failed(ResultCode.SQLINSERTERROR);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLINSERTERROR);
        }
    }

    @DeleteMapping(value = "/role/{id}")
    public Result delete(@PathVariable(value = "id") Serializable id){
        try {
            if (id != null && roleService.removeById(id))
                return Result.success();
            else
                return Result.failed(ResultCode.SQLDELETEERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/role")
    public Result update(@RequestBody Role role) {
        try {
            if (roleService.updateById(role))
                return Result.success();
            else
                return Result.failed(ResultCode.SQLUPDATEERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

    @GetMapping(value = "/role/{id}")
    public Result findOne(@PathVariable("id") Serializable id) {
        try {
            Role role = roleService.getById(id);
            return Result.success(role);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

    @GetMapping(value = "/roles",produces = "application/json; charset=utf-8")
    public Result findPages(
            @RequestParam(value = "keyword",required = false) String keyword,
            @RequestParam(value = "page",required = false,defaultValue = "1") Long page,
            @RequestParam(value = "limit",required = false,defaultValue = "20") Long limit,
            @RequestParam(value = "orderby",required = false) String orderby
    ){
        try {
            Page<Role> pager = new Page<>(page,limit);
            QueryWrapper<Role> wrapper = new QueryWrapper<>();
            if (orderby != null){
                String[] split = orderby.split(",");
                if (split[1].toLowerCase().equals("desc"))
                    wrapper.orderByDesc(split[0]);
                else
                    wrapper.orderByAsc(split[0]);
            }
            if (keyword != null)
                wrapper.likeRight("r_name",keyword);
            Page<Role> pages = roleService.page(pager, wrapper);
            return Result.success(pages);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }
}
