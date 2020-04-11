package com.h2sj.douyin.domain.repository;

import com.h2sj.douyin.domain.entity.VideoComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCommentRepository extends JpaRepository<VideoComment,Long>, JpaSpecificationExecutor<VideoComment> {
}