package com.cloudthat.ecomappv3.repository;

import com.cloudthat.ecomappv3.Main;
import com.cloudthat.ecomappv3.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Entity<ID>, ID> implements Repository<T, ID> {
    private  final Map<ID,T> entities = new HashMap<>();


    @Override
    public T findById(ID id) {
        return entities.get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public T save(T entity) {
        entities.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        entities.remove(entity.getId());
    }
}
