package com.h2sj.douyin.admin.controller;

import com.h2sj.douyin.admin.service.RoleService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/role",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody Role role){
        try {
            if (roleService.save(role) != null){
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
    public Result delete(@PathVariable(value = "id") Long id){
        try {
            roleService.deleteById(id);
            return Result.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/role")
    public Result update(@RequestBody Role role) {
        try {
            if (roleService.update(role) != null)
                return Result.success();
            else
                return Result.failed(ResultCode.SQLUPDATEERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

    @GetMapping(value = "/role/{id}")
    public Result findOne(@PathVariable("id") Long id) {
        try {
            Role role = roleService.findOneById(id);
            return Result.success(role);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

    @GetMapping(value = "/roles",produces = "application/json; charset=utf-8")
    public Result findList(){
        try {
            List<Role> list = roleService.findList();
            return Result.success(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }
}
