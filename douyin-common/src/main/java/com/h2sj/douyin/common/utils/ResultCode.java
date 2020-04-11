package com.h2sj.douyin.common.utils;

public enum  ResultCode {
    SUCCESS(200,"操作成功"),
    LOGINSUCCESS(200,"登录成功"),
    SQLINSERTERROR(1000,"数据库插入错误"),
    SQLDELETEERROR(1001,"数据库删除错误"),
    SQLUPDATEERROR(1002,"数据库修改错误"),
    SQLSELECTERROR(1003,"数据库查询错误"),
    FILEUPLOADERROR(2000,"文件上传失败");

    Integer code;
    String info;

    ResultCode(Integer code,String info){
        this.code = code;
        this.info = info;
    }
}
