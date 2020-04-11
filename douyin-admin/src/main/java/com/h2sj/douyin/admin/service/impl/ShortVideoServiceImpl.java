package com.h2sj.douyin.admin.service.impl;

import com.h2sj.douyin.admin.service.ShortVideoService;
import com.h2sj.douyin.domain.entity.Member;
import com.h2sj.douyin.domain.entity.ShortVideo;
import com.h2sj.douyin.domain.repository.ShortVideoRepository;
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
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class ShortVideoServiceImpl implements ShortVideoService {

    @Autowired
    private ShortVideoRepository repository;

    @Transactional
    @Override
    public ShortVideo save(ShortVideo object) {
        return repository.save(object);
    }

    @Transactional
    @Override
    public void delete(ShortVideo object) {
        repository.delete(object);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public ShortVideo update(ShortVideo object) {
        return repository.save(object);
    }

    @Override
    public ShortVideo findOne(ShortVideo object) {
        Example<ShortVideo> example = Example.of(object);
        Optional<ShortVideo> one = repository.findOne(example);
        return one.orElseGet(null);
    }

    @Override
    public ShortVideo findOneById(Long id) {
        Optional<ShortVideo> byId = repository.findById(id);
        return byId.orElseGet(null);
    }

    @Override
    public List<ShortVideo> findList(ShortVideo object) {
        Example<ShortVideo> example = Example.of(object);
        return repository.findAll(example);
    }

    @Override
    public Page<ShortVideo> findPages(String keyword, Integer page, Integer limit, String span) {
        return repository.findAll(new Specification<ShortVideo>() {
            @Override
            public Predicate toPredicate(Root<ShortVideo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (keyword != null) {
                    Predicate svTitle = criteriaBuilder.like(root.get("svTitle"), keyword);
                    if (span == null) return svTitle;
                    else {
                        String[] spans = span.split(",");
                        Predicate svCreatedate = criteriaBuilder.between(root.get("svCreatedate"), spans[0], spans[1]);
                        return criteriaBuilder.and(svTitle,svCreatedate);
                    }
                }else {
                    if (span == null) return null;
                    else {
                        String[] spans = span.split(",");
                        return criteriaBuilder.between(root.get("svCreatedate"), spans[0], spans[1]);
                    }
                }
            }
        }, PageRequest.of(page,limit));
    }
}
