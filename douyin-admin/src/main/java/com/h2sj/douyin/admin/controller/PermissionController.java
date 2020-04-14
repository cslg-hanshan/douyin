package com.h2sj.douyin.admin.controller;

import com.h2sj.douyin.admin.service.PermissionService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping(value = "/permission",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody Permission permission){
        try {
            permissionService.save(permission);
            return Result.success();
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLINSERTERROR);
        }
    }

    @DeleteMapping(value = "/permission/{id}",produces = "application/json; charset=utf-8")
    public Result delete(@PathVariable("id") Long id){
        try {
            permissionService.removeById(id);
            return Result.success();
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/permission",produces = "application/json; charset=utf-8")
    public Result update(@RequestBody Permission permission){
        try {
            if (permissionService.updateById(permission)){
                return Result.success();
            }else {
                return Result.failed(ResultCode.SQLUPDATEERROR);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

    @GetMapping(value = "/permission/{id}",produces = "application/json; charset=utf-8")
    public Result findOne(@PathVariable("id") Long id){
        try {
            Permission permission = permissionService.getById(id);
            return Result.success(permission);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }

    }

    @GetMapping(value = "/permissions",produces = "application/json; charset=utf-8")
    public Result findPages(){
        try {
            List<Permission> list = permissionService.list();
            return Result.success(list);
        } catch (Exception ex) {
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

}
