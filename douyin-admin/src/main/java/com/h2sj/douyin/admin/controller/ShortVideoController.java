package com.h2sj.douyin.admin.controller;

import com.h2sj.douyin.admin.service.ShortVideoService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.ShortVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortVideoController {

    @Autowired
    private ShortVideoService shortVideoService;

    @PostMapping(value = "/shortvideo",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody ShortVideo shortvideo){
        try {
            if (shortVideoService.save(shortvideo) != null){
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
    public Result delete(@PathVariable(value = "id") Long id){
        try {
            shortVideoService.deleteById(id);
            return Result.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/shortvideo")
    public Result update(@RequestBody ShortVideo shortvideo) {
        try {
            if (shortVideoService.update(shortvideo) != null)
                return Result.success();
            else
                return Result.failed(ResultCode.SQLUPDATEERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

    @GetMapping(value = "/shortvideo/{id}")
    public Result findOne(@PathVariable("id") Long id) {
        try {
            ShortVideo shortvideo = shortVideoService.findOneById(id);
            return Result.success(shortvideo);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

    @GetMapping(value = "/shortvideos",produces = "application/json; charset=utf-8")
    public Result findPages(
            @RequestParam(value = "keyword",required = false) String keyword,
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(value = "limit",required = false,defaultValue = "20") Integer limit,
            @RequestParam(value = "span",required = false) String span
    ){
        try {
            Page<ShortVideo> pages = shortVideoService.findPages(keyword, page, limit, span);
            return Result.success(pages);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }
}
