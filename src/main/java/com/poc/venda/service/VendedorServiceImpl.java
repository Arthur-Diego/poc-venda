package com.poc.venda.service;

import com.poc.venda.model.Venda;
import com.poc.venda.model.Vendedor;
import com.poc.venda.repository.EntityBaseRepository;
import com.poc.venda.repository.EntityBaseRepositoryImpl;

public class VendedorServiceImpl extends EntityBaseRepositoryImpl<Vendedor, Long>
        implements VendedorService{
    public VendedorServiceImpl(EntityBaseRepository<Vendedor, Long> entityBaseRepository) {
        super(entityBaseRepository);
    }
}
