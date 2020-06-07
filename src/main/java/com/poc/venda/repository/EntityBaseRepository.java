package com.poc.venda.repository;

import com.poc.venda.model.EntityInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface EntityBaseRepository<T extends EntityInterface, ID extends Serializable>
        extends JpaRepository<T, ID> {

}
