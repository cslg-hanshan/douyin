package com.h2sj.douyin.admin.controller.base;

import com.h2sj.douyin.common.utils.Result;

import java.io.Serializable;

public interface BaseController<T> {

    public Result save(T obj);

    public Result delete(Serializable id);

    public Result update(T obj);

    public Result findOne(Serializable id);

    public Result findPages(String keyword,Long page,Long limit,String orderby);

}
