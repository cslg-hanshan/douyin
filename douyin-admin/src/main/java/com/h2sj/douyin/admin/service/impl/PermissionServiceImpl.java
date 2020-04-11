package com.h2sj.douyin.admin.service.impl;

import com.h2sj.douyin.admin.service.PermissionService;
import com.h2sj.douyin.domain.entity.Permission;
import com.h2sj.douyin.domain.repository.PermissionRepository;
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
public class PermissionServiceImpl implements PermissionService {

    @Autowired(required = false)
    private PermissionRepository repository;

    @Transactional
    @Override
    public Permission save(Permission object) {
        return repository.save(object);
    }

    @Transactional
    @Override
    public void delete(Permission object) {
        repository.delete(object);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public Permission update(Permission object) {
        return repository.save(object);
    }

    @Override
    public Permission findOne(Permission object) {
        Example<Permission> example = Example.of(object);
        Optional<Permission> one = repository.findOne(example);
        return one.orElseGet(null);
    }

    @Override
    public Permission findOneById(Long id) {
        Optional<Permission> byId = repository.findById(id);
        return byId.orElseGet(null);
    }

    @Override
    public List<Permission> findList() {
        return repository.findAll();
    }

    @Override
    public List<Permission> findListByRid(Long id) {
        return repository.findListByRid(id);
    }
}
