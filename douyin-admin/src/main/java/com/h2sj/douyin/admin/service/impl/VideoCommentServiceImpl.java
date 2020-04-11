package com.h2sj.douyin.admin.service.impl;

import com.h2sj.douyin.admin.service.VideoCommentService;
import com.h2sj.douyin.domain.entity.VideoComment;
import com.h2sj.douyin.domain.repository.VideoCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class VideoCommentServiceImpl implements VideoCommentService {

    @Autowired
    private VideoCommentRepository repository;

    @Transactional
    @Override
    public VideoComment save(VideoComment object) {
        return repository.save(object);
    }

    @Transactional
    @Override
    public void delete(VideoComment object) {
        repository.delete(object);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public VideoComment update(VideoComment object) {
        return null;
    }

    @Override
    public VideoComment findOne(VideoComment object) {
        Example<VideoComment> example = Example.of(object);
        Optional<VideoComment> one = repository.findOne(example);
        return one.orElseGet(null);
    }

    @Override
    public VideoComment findOneById(Long id) {
        Optional<VideoComment> byId = repository.findById(id);
        return byId.orElseGet(null);
    }

    @Override
    public List<VideoComment> findList(VideoComment object) {
        Example<VideoComment> example = Example.of(object);
        return repository.findAll(example);
    }

    @Override
    public Page<VideoComment> findPages(String keyword, Integer page, Integer limit, String span) {
        return repository.findAll(new Specification<VideoComment>() {
            @Override
            public Predicate toPredicate(Root<VideoComment> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (keyword != null) {
                    Predicate vcContent = criteriaBuilder.like(root.get("vcContent"), keyword);
                    if (span == null) return vcContent;
                    else {
                        String[] spans = span.split(",");
                        Predicate vcCreatedate = criteriaBuilder.between(root.get("vcCreatedate"), spans[0], spans[1]);
                        return criteriaBuilder.and(vcContent,vcCreatedate);
                    }
                }else {
                    if (span == null) return null;
                    else {
                        String[] spans = span.split(",");
                        return criteriaBuilder.between(root.get("vcCreatedate"), spans[0], spans[1]);
                    }
                }
            }
        }, PageRequest.of(page,limit));
    }
}
