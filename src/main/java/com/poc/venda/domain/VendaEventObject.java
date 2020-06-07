package com.poc.venda.domain;

import com.poc.venda.kafka.producer.ProducerCommon;
import com.poc.venda.model.Carro;
import com.poc.venda.model.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VendaEventObject implements ProducerCommon {

        private Integer vendaEventId;
        private Vendedor vendedor;
        private Carro carro;

        @Override
        public Integer getKey() {
            return this.vendaEventId;
        }

}
