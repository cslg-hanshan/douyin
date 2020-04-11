package com.h2sj.douyin.common.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class QiniuCloudUtils {

    private static final String ACCESS_KEY = "7RDXD2tsfI2msWTohV8LTjxr-klYMRBf98WZxk9N";

    private static final String SECRET_KEY = "Egye0xtv-nujIw2RsPK5tP-knOjFjh1L4DMKNlZ1";

    private static final String bucketname = "mydouyin";

    private static final String uploadDomain = "http://q7skf5igb.bkt.clouddn.com/";

    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    public static String upload(File file) throws IOException {
        Configuration configuration = new Configuration(Region.region0());
        UploadManager uploadManager = new UploadManager(configuration);
        String uploadToken = auth.uploadToken(bucketname);
        try {
            UUID uuid = UUID.randomUUID();
            String name = uuid.toString().replace("-", "");
            uploadManager.put(file, name, uploadToken);
            return uploadDomain+name;
        }catch (QiniuException qe) {
            qe.printStackTrace();
            return null;
        }
    }

    public static String upload(MultipartFile mFile) throws IOException {
        Configuration configuration = new Configuration(Region.region0());
        UploadManager uploadManager = new UploadManager(configuration);
        String uploadToken = auth.uploadToken(bucketname);
        try {
            InputStream inputStream = mFile.getInputStream();
            UUID uuid = UUID.randomUUID();
            String name = uuid.toString().replace("-", "");
            String contentType = mFile.getContentType();
            System.out.println(contentType);
            uploadManager.put(inputStream, name, uploadToken,new StringMap(),contentType);
            return uploadDomain+name;
        }catch (QiniuException qe) {
            qe.printStackTrace();
            return null;
        }

    }

}
