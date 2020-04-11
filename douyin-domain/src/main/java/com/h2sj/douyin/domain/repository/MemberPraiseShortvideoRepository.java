package com.h2sj.douyin.domain.repository;

import com.h2sj.douyin.domain.entity.MemberPraiseShortvideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPraiseShortvideoRepository extends JpaRepository<MemberPraiseShortvideo,Long>, JpaSpecificationExecutor<MemberPraiseShortvideo> {
}
