package com.h2sj.douyin.admin.service.impl;

import com.h2sj.douyin.admin.service.RoleService;
import com.h2sj.douyin.domain.entity.Role;
import com.h2sj.douyin.domain.repository.RoleRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository repository;

    @Transactional
    @Override
    public Role save(Role object) {
        return repository.save(object);
    }

    @Transactional
    @Override
    public void delete(Role object) {
        repository.delete(object);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public Role update(Role object) {
        return repository.save(object);
    }

    @Override
    public Role findOne(Role object) {
        Example<Role> example = Example.of(object);
        Optional<Role> one = repository.findOne(example);
        return one.orElseGet(null);
    }

    @Override
    public Role findOneById(Long id) {
        Optional<Role> byId = repository.findById(id);
        return byId.orElseGet(null);
    }

    @Override
    public List<Role> findList() {
        return repository.findAll();
    }

}
