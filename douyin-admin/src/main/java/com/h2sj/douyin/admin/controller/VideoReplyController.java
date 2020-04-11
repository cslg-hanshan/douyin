package com.h2sj.douyin.admin.controller;

import com.h2sj.douyin.admin.service.VideoReplyService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.VideoReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class VideoReplyController {

    @Autowired
    private VideoReplyService videoReplyService;

    @PostMapping(value = "/videoreply",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody VideoReply videoreply){
        try {
            VideoReply save = videoReplyService.save(videoreply);
            return Result.success(save);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLINSERTERROR);
        }
    }

    @DeleteMapping(value = "/videoreply/{id}")
    public Result delete(@PathVariable(value = "id") Long id){
        try {
            videoReplyService.deleteById(id);
            return Result.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/videoreply")
    public Result update(@RequestBody VideoReply videoreply) {
        try {
            VideoReply update = videoReplyService.update(videoreply);
            return Result.success(update);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

    @GetMapping(value = "/videoreply/{id}")
    public Result findOne(@PathVariable("id") Long id) {
        try {
            VideoReply videoreply = videoReplyService.findOneById(id);
            return Result.success(videoreply);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

    @GetMapping(value = "/videoreplys",produces = "application/json; charset=utf-8")
    public Result findPages(
            @RequestParam(value = "keyword",required = false) String keyword,
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(value = "limit",required = false,defaultValue = "20") Integer limit,
            @RequestParam(value = "span",required = false) String span
    ){
        try {
            Page<VideoReply> pages = videoReplyService.findPages(keyword, page, limit, span);
            return Result.success(pages);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }
}
