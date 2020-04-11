package com.h2sj.douyin.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.h2sj.douyin.domain.entity.Member;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;


@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}
