package com.h2sj.douyin.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h2sj.douyin.admin.service.VideoCommentService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.VideoComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VideoCommentController {

    @Autowired
    private VideoCommentService videoCommentService;

    @PostMapping(value = "/videocomment",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody VideoComment videocomment){
        try {
            videoCommentService.save(videocomment);
            return Result.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLINSERTERROR);
        }
    }

    @DeleteMapping(value = "/videocomment/{id}")
    public Result delete(@PathVariable(value = "id") Long id){
        try {
            videoCommentService.removeById(id);
            return Result.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/videocomment")
    public Result update(@RequestBody VideoComment videocomment) {
        try {
            videoCommentService.updateById(videocomment);
            return Result.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

    @GetMapping(value = "/videocomment/{id}")
    public Result findOne(@PathVariable("id") Long id) {
        try {
            VideoComment videocomment = videoCommentService.getById(id);
            return Result.success(videocomment);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

    @GetMapping(value = "/videocomments",produces = "application/json; charset=utf-8")
    public Result findPages(
            @RequestParam(value = "keyword",required = false) String keyword,
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(value = "limit",required = false,defaultValue = "20") Integer limit,
            @RequestParam(value = "span",required = false) String span
    ){
        try {
            Page<VideoComment> pages = videoCommentService.findPages(keyword, page, limit, span);
            return Result.success(pages);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

}
