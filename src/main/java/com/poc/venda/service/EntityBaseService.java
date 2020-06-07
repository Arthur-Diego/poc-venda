package com.poc.venda.service;

import com.poc.venda.model.EntityInterface;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface EntityBaseService <T extends EntityInterface, ID extends Serializable>{

    public T save(T entity);
    public List<T> findAll();
    public Optional<T> findById(ID entityId);
    public T update(T entity);
    public T updateById(T entity, ID entityId);
    public void delete(T entity);
    public void deleteById(ID entityId);

}
