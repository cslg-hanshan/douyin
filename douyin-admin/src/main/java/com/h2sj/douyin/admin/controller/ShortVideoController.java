package com.h2sj.douyin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h2sj.douyin.admin.controller.base.BaseController;
import com.h2sj.douyin.admin.service.ShortVideoService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.ShortVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class ShortVideoController implements BaseController<ShortVideo> {

    @Autowired
    private ShortVideoService shortVideoService;

    @PostMapping(value = "/shortvideo",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody ShortVideo shortvideo){
        try {
            if (shortVideoService.save(shortvideo)){
                return Result.success();
            }else {
                return Result.failed(ResultCode.SQLINSERTERROR);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLINSERTERROR);
        }
    }

    @DeleteMapping(value = "/shortvideo/{id}")
    public Result delete(@PathVariable(value = "id") Serializable id){
        try {
            if (id != null && shortVideoService.removeById(id))
                return Result.success();
            else
                return Result.failed(ResultCode.SQLDELETEERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/shortvideo")
    public Result update(@RequestBody ShortVideo shortvideo) {
        try {
            if (shortVideoService.updateById(shortvideo))
                return Result.success();
            else
                return Result.failed(ResultCode.SQLUPDATEERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

    @GetMapping(value = "/shortvideo/{id}")
    public Result findOne(@PathVariable("id") Serializable id) {
        try {
            ShortVideo shortvideo = shortVideoService.getById(id);
            return Result.success(shortvideo);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

    @GetMapping(value = "/shortvideos",produces = "application/json; charset=utf-8")
    public Result findPages(
            @RequestParam(value = "keyword",required = false) String keyword,
            @RequestParam(value = "page",required = false,defaultValue = "1") Long page,
            @RequestParam(value = "limit",required = false,defaultValue = "20") Long limit,
            @RequestParam(value = "orderby",required = false) String orderby
    ){
        try {
            Page<ShortVideo> pager = new Page<>(page,limit);
            QueryWrapper<ShortVideo> wrapper = new QueryWrapper<>();
            if (orderby != null){
                String[] split = orderby.split(",");
                if (split[1].toLowerCase().equals("desc"))
                    wrapper.orderByDesc(split[0]);
                else
                    wrapper.orderByAsc(split[0]);
            }
            if (keyword != null)
                wrapper.likeRight("sv_title",keyword);
            Page<ShortVideo> pages = shortVideoService.page(pager, wrapper);
            return Result.success(pages);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }
}
