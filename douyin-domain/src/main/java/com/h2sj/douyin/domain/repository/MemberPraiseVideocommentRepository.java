package com.h2sj.douyin.domain.repository;

import com.h2sj.douyin.domain.entity.MemberPraiseVideocomment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPraiseVideocommentRepository extends JpaRepository<MemberPraiseVideocomment,Long>, JpaSpecificationExecutor<MemberPraiseVideocomment> {
}
