package com.poc.venda.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Venda implements EntityInterface<Venda, Long>{

    @Id
    @GeneratedValue
    private Long idVenda;

    @NotNull
    @Valid
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id",
            foreignKey = @ForeignKey(name = "fk_car_id", value = ConstraintMode.CONSTRAINT))
    private Carro carro;

    @Column(name = "vendedor_id")
    private Long idVendedor;


    @Override
    public Long getId() {
        return null;
    }
}
