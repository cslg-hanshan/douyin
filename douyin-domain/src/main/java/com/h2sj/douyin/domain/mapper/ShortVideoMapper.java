package com.h2sj.douyin.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.h2sj.douyin.domain.entity.ShortVideo;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;

@Mapper
public interface ShortVideoMapper extends BaseMapper<ShortVideo> {

    @Results(id = "shortvideo",value = {
            @Result(column = "sv_id",property = "svId"),
            @Result(column = "sv_title",property = "svTitle"),
            @Result(column = "sv_createdate",property = "svCreatedate"),
            @Result(column = "sv_url",property = "svUrl"),
            @Result(column = "sv_viewtimes",property = "svViewtimes"),
            @Result(column = "m_id",property = "mId"),
            @Result(column = "m_id",property = "svAuthor",
                    one = @One(select = "com.h2sj.douyin.domain.mapper.MemberMapper.selectById"))
    })
    @Select(value = "select * from db_shortvideo where sv_id=#{id} limit 1;")
    public ShortVideo findDetailById(Serializable id);
}
