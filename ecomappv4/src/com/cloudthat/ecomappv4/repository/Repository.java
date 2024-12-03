package com.cloudthat.ecomappv4.repository;



import com.cloudthat.ecomappv4.entity.Entity;

import java.util.List;

public interface Repository<T extends Entity<ID>, ID>{
    T findById(ID id);
    List<T> findAll();
    T save(T entity);
    void delete(T entity);
}
