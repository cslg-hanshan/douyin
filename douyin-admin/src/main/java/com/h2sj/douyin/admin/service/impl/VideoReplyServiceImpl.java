package com.h2sj.douyin.admin.service.impl;

import com.h2sj.douyin.admin.service.VideoReplyService;
import com.h2sj.douyin.domain.entity.VideoReply;
import com.h2sj.douyin.domain.repository.VideoReplyRepository;
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
public class VideoReplyServiceImpl implements VideoReplyService {

    private VideoReplyRepository repository;

    @Transactional
    @Override
    public VideoReply save(VideoReply object) {
        return repository.save(object);
    }

    @Transactional
    @Override
    public void delete(VideoReply object) {
        repository.delete(object);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public VideoReply update(VideoReply object) {
        return null;
    }

    @Override
    public VideoReply findOne(VideoReply object) {
        Example<VideoReply> example = Example.of(object);
        Optional<VideoReply> one = repository.findOne(example);
        return one.orElseGet(null);
    }

    @Override
    public VideoReply findOneById(Long id) {
        Optional<VideoReply> byId = repository.findById(id);
        return byId.orElseGet(null);
    }

    @Override
    public List<VideoReply> findList(VideoReply object) {
        Example<VideoReply> example = Example.of(object);
        return repository.findAll(example);
    }

    @Override
    public Page<VideoReply> findPages(String keyword, Integer page, Integer limit, String span) {
        return repository.findAll(new Specification<VideoReply>() {
            @Override
            public Predicate toPredicate(Root<VideoReply> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (keyword != null) {
                    Predicate vrContent = criteriaBuilder.like(root.get("vrContent"), keyword);
                    if (span == null) return vrContent;
                    else {
                        String[] spans = span.split(",");
                        Predicate vrCreatedate = criteriaBuilder.between(root.get("vrCreatedate"), spans[0], spans[1]);
                        return criteriaBuilder.and(vrContent,vrCreatedate);
                    }
                }else {
                    if (span == null) return null;
                    else {
                        String[] spans = span.split(",");
                        return criteriaBuilder.between(root.get("vrCreatedate"), spans[0], spans[1]);
                    }
                }
            }
        }, PageRequest.of(page,limit));
    }
}
