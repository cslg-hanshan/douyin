package com.h2sj.douyin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h2sj.douyin.admin.controller.base.BaseController;
import com.h2sj.douyin.admin.service.PermissionService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
public class PermissionController implements BaseController<Permission> {

    @Autowired
    private PermissionService permissionService;

    @PostMapping(value = "/permission",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody Permission permission){
        try {
            if (permissionService.save(permission)){
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
    public Result delete(@PathVariable("id") Serializable id){
        try {
            if (permissionService.removeById(id)) {
                return Result.success();
            }else {
                return Result.failed(ResultCode.SQLDELETEERROR);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/permission",produces = "application/json; charset=utf-8")
    public Result update(@RequestBody Permission permission){
        try {
            UpdateWrapper<Permission> wrapper = new UpdateWrapper<>();
            wrapper.lambda().eq(Permission::getPId,permission.getPId());

            if (permissionService.update(permission,wrapper)){
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
    public Result findOne(@PathVariable("id") Serializable id){
        try {
            Permission permission = permissionService.getById(id);
            return Result.success(permission);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }

    }

    @GetMapping(value = "/permissions",produces = "application/json; charset=utf-8")
    public Result findPages(
            @RequestParam(value = "keyword",required = false) String keyword,
            @RequestParam(value = "page",required = false,defaultValue = "1") Long page,
            @RequestParam(value = "limit",required = false,defaultValue = "20") Long limit,
            @RequestParam(value = "orderby",required = false) String orderby
    ){
        try {
            Page<Permission> pager = new Page<>(page,limit);
            QueryWrapper<Permission> wrapper = new QueryWrapper<>();
            if (orderby != null){
                String[] split = orderby.split(",");
                if (split[1].toLowerCase().equals("desc"))
                    wrapper.orderByDesc(split[0]);
                else
                    wrapper.orderByAsc(split[0]);
            }
            if (keyword != null)
                wrapper.likeRight("p_description",keyword);
            Page<Permission> pages = permissionService.page(pager, wrapper);
            return Result.success(pages);
        } catch (Exception ex) {
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

    @GetMapping(value = "/permissions/role/{id}",produces = "application/json; charset=utf-8")
    public Result findListByRoleId(@PathVariable(value = "id") Long id){
        try {
            List<Permission> list = permissionService.findListByRoleId(id);
            return Result.success(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

}
