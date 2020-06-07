package com.poc.venda.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Carro implements EntityInterface<Carro, Long>{

    @Id
    @Column(name = "car_id")
    public Long idCarro;

    @Column(name = "car_nome_carro")
    public String nomeCarro;

    @Override
    public Long getId() {
        return this.idCarro;
    }

}
