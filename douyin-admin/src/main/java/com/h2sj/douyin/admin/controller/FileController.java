package com.h2sj.douyin.admin.controller;

import com.h2sj.douyin.common.utils.QiniuCloudUtils;
import com.h2sj.douyin.common.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {

    @PostMapping(value = "/uploadimg",produces = "application/json; charset=utf-8")
    public Result uploadImage(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException {
        String upload = QiniuCloudUtils.upload(multipartFile);
        return Result.success(upload);
    }

    @PostMapping(value = "/uploadvideo",produces = "application/json; charset=utf-8")
    public Result uploadVideo(@RequestParam(value = "file") MultipartFile multipartFile) {
        return Result.success();
    }
}
