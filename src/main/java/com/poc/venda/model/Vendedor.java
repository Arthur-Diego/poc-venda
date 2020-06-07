package com.poc.venda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Vendedor implements EntityInterface<Vendedor, Long>{

    @Id
    @GeneratedValue
    @Column(name = "vendedor_id")
    private Long idVendedor;

    @Column(name = "nome")
    private String nomeVendedor;

    @Override
    public Long getId() {
        return this.idVendedor;
    }
}
