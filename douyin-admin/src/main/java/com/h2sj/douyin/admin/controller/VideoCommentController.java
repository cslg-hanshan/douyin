package com.h2sj.douyin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h2sj.douyin.admin.controller.base.BaseController;
import com.h2sj.douyin.admin.service.VideoCommentService;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import com.h2sj.douyin.domain.entity.VideoComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class VideoCommentController implements BaseController<VideoComment> {

    @Autowired
    private VideoCommentService videoCommentService;

    @PostMapping(value = "/videocomment",produces = "application/json; charset=utf-8")
    public Result save(@RequestBody VideoComment videocomment){
        try {
            if (videoCommentService.save(videocomment)){
                return Result.success();
            }else {
                return Result.failed(ResultCode.SQLINSERTERROR);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLINSERTERROR);
        }
    }

    @DeleteMapping(value = "/videocomment/{id}")
    public Result delete(@PathVariable(value = "id") Serializable id){
        try {
            if (id != null && videoCommentService.removeById(id))
                return Result.success();
            else
                return Result.failed(ResultCode.SQLDELETEERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLDELETEERROR);
        }
    }

    @PutMapping(value = "/videocomment")
    public Result update(@RequestBody VideoComment videocomment) {
        try {
            if (videoCommentService.updateById(videocomment))
                return Result.success();
            else
                return Result.failed(ResultCode.SQLUPDATEERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLUPDATEERROR);
        }
    }

    @GetMapping(value = "/videocomment/{id}")
    public Result findOne(@PathVariable("id") Serializable id) {
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
            @RequestParam(value = "page",required = false,defaultValue = "1") Long page,
            @RequestParam(value = "limit",required = false,defaultValue = "20") Long limit,
            @RequestParam(value = "orderby",required = false) String orderby
    ){
        try {
            Page<VideoComment> pager = new Page<>(page,limit);
            QueryWrapper<VideoComment> wrapper = new QueryWrapper<>();
            if (orderby != null){
                String[] split = orderby.split(",");
                if (split[1].toLowerCase().equals("desc"))
                    wrapper.orderByDesc(split[0]);
                else
                    wrapper.orderByAsc(split[0]);
            }
            if (keyword != null)
                wrapper.likeRight("vc_content",keyword);
            Page<VideoComment> pages = videoCommentService.page(pager, wrapper);
            return Result.success(pages);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.failed(ResultCode.SQLSELECTERROR);
        }
    }

}
