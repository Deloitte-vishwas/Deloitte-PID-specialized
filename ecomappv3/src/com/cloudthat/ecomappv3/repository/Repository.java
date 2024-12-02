package com.cloudthat.ecomappv3.repository;

import com.cloudthat.ecomappv3.entity.Entity;

import java.util.List;

public interface Repository<T extends Entity<ID>, ID>{
    T findById(ID id);
    List<T> findAll();
    T save(T entity);
    void delete(T entity);
}
