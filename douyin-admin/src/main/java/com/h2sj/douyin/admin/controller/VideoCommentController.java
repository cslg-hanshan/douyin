package com.h2sj.douyin.admin.controller;

import com.h2sj.douyin.admin.service.VideoCommentService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.VideoComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class VideoCommentController {

    @Autowired
    private VideoCommentService videoCommentService;

    @PostMapping(value = "/videocomment",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody VideoComment videocomment){
        try {
            VideoComment save = videoCommentService.save(videocomment);
            return Result.success(save);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLINSERTERROR);
        }
    }

    @DeleteMapping(value = "/videocomment/{id}")
    public Result delete(@PathVariable(value = "id") Long id){
        try {
            videoCommentService.deleteById(id);
            return Result.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/videocomment")
    public Result update(@RequestBody VideoComment videocomment) {
        try {
            VideoComment update = videoCommentService.update(videocomment);
            return Result.success(update);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

    @GetMapping(value = "/videocomment/{id}")
    public Result findOne(@PathVariable("id") Long id) {
        try {
            VideoComment videocomment = videoCommentService.findOneById(id);
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
