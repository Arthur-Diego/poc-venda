package com.poc.venda.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.poc.venda.model.Venda;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface VendaService extends EntityBaseService<Venda, Long>{

    public void processVendaEvento(ConsumerRecord<Integer,String> consumerRecord) throws JsonProcessingException;
    public void handleRecovery(ConsumerRecord<Integer,String> record);

}
