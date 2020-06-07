package com.poc.venda.service;

import com.poc.venda.model.Carro;
import com.poc.venda.repository.EntityBaseRepository;
import com.poc.venda.repository.EntityBaseRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class CarroServiceImpl extends EntityBaseRepositoryImpl<Carro, Long>
        implements CarroService{

    public CarroServiceImpl(EntityBaseRepository<Carro, Long> entityBaseRepository) {
        super(entityBaseRepository);
    }
}

