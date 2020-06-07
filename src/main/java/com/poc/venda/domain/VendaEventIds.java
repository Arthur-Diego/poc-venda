package com.poc.venda.domain;

import com.poc.venda.kafka.producer.ProducerCommon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VendaEventIds implements ProducerCommon {


    private Integer vendaEventId;
    private VendaEventType vendaEventType;
    private Long vendedor;
    private Long carro;

    @Override
    public Integer getKey() {
        return this.vendaEventId;
    }
}


