package com.h2sj.douyin.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static boolean upload(MultipartFile file, String path, String fileName) {
        //确定上传的文件名
        String realPath = path + fileName;
        System.out.println("上传文件：" + realPath);
        File dest = new File(realPath);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            //保存文件
            file.transferTo(dest);
            return true;
        }  catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
