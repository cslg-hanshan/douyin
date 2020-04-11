package com.h2sj.douyin.admin.service.impl;

import com.h2sj.douyin.admin.service.MemberService;
import com.h2sj.douyin.domain.entity.Member;
import com.h2sj.douyin.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired(required = false)
    private MemberRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    @Override
    public Member save(Member object) {
        object.setMPassword(encoder.encode(object.getMPassword()));
        return repository.save(object);
    }

    @Transactional
    @Override
    public void delete(Member object) {
        repository.delete(object);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public Member update(Member object) {
        Member byId = findOneById(object.getMId());
        if (!byId.getMPassword().equals(object.getMPassword()))
            object.setMPassword(encoder.encode(object.getMPassword()));
        return repository.save(object);
    }

    @Override
    public Member findOne(Member object) {
        Example<Member> example = Example.of(object);
        Optional<Member> one = repository.findOne(example);
        return one.orElseGet(null);
    }

    @Override
    public Member findOneById(Long id) {
        Optional<Member> byId = repository.findById(id);
        return byId.orElseGet(null);
    }

    @Override
    public List<Member> findList(Member object) {
        Example<Member> example = Example.of(object);
        return repository.findAll(example);
    }

    @Override
    public Page<Member> findPages(String keyword, Integer page, Integer limit, String span) {
        return repository.findAll(new Specification<Member>() {
            @Override
            public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (keyword != null) {
                    Predicate mUsername = criteriaBuilder.like(root.get("mUsername"), keyword);
                    if (span == null) return mUsername;
                    else {
                        String[] spans = span.split(",");
                        Predicate mBirthday = criteriaBuilder.between(root.get("mBirthday"), spans[0], spans[1]);
                        return criteriaBuilder.and(mUsername,mBirthday);
                    }
                }else {
                    if (span == null) return null;
                    else {
                        String[] spans = span.split(",");
                        return criteriaBuilder.between(root.get("mBirthday"), spans[0], spans[1]);
                    }
                }
            }
        }, PageRequest.of(page,limit));
    }
}
