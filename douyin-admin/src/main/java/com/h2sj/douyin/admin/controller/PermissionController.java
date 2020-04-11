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
            if (permissionService.save(permission) != null){
                return Result.success();
            }else {
                return Result.failed(ResultCode.SQLINSERTERROR);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLINSERTERROR);
        }
    }

    @DeleteMapping(value = "/permission/{id}",produces = "application/json; charset=utf-8")
    public Result delete(@PathVariable("id") Long id){
        try {
            permissionService.deleteById(id);
            return Result.success();
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/permission",produces = "application/json; charset=utf-8")
    public Result update(@RequestBody Permission permission){
        try {
            if (permissionService.update(permission) != null){
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
            Permission permission = permissionService.findOneById(id);
            return Result.success(permission);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }

    }

    @GetMapping(value = "/permissions",produces = "application/json; charset=utf-8")
    public Result findPages(){
        try {
            List<Permission> list = permissionService.findList();
            return Result.success(list);
        } catch (Exception ex) {
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

    @GetMapping(value = "/permissions/role/{id}",produces = "application/json; charset=utf-8")
    public Result findListByRoleId(@PathVariable(value = "id") Long id){
        try {
            List<Permission> list = permissionService.findListByRid(id);
            return Result.success(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

}
