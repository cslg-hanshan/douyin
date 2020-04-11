package com.h2sj.douyin.common.utils;

import lombok.Data;

@Data
public class Result {
    private String msg;
    private Integer code;
    private Object data;

    private Result(ResultCode resultCode){
        this.code = resultCode.code;
        this.msg = resultCode.info;
    }

    private Result(ResultCode code, Object data){
        this.msg = code.info;
        this.code = code.code;
        this.data = data;
    }

    public static Result success(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result success(Object data){
        return new Result(ResultCode.SUCCESS,data);
    }

    public static Result failed(ResultCode resultCode){
        return new Result(resultCode);
    }

    public static Result failed(ResultCode resultCode,Object data){
        return new Result(resultCode,data);
    }
}
