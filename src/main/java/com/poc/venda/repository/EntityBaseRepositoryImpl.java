package com.poc.venda.repository;

import com.poc.venda.model.EntityInterface;
import com.poc.venda.service.EntityBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntityBaseRepositoryImpl<T extends EntityInterface, ID extends Serializable>
        implements EntityBaseService<T, ID> {

    private EntityBaseRepository<T, ID> entityBaseRepository;

    @Autowired
    public EntityBaseRepositoryImpl(EntityBaseRepository<T, ID> entityBaseRepository) {
        this.entityBaseRepository = entityBaseRepository;
    }

    @Override
    public T save(T entity) {
        return (T) entityBaseRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return entityBaseRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID entityId) {
        return entityBaseRepository.findById(entityId);
    }

    @Override
    public T update(T entity) {
        return (T) entityBaseRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = entityBaseRepository.findById(entityId);
        if(optional.isPresent()){
            return (T) entityBaseRepository.save(entity);
        }else{
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        entityBaseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        entityBaseRepository.deleteById(entityId);
    }

}
