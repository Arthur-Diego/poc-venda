package com.poc.venda.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.poc.venda.service.VendaServiceImplEvent;
import com.poc.venda.utils.StringUtilsTopics;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VendaËventObjectConsumer {
    @Autowired
    private VendaServiceImplEvent vendedorEventsService;

    @KafkaListener(topics = {StringUtilsTopics.TOPIC_VENDA_OBJECT}, containerFactory = "kafkaListenerContainerFactoryObject")
    public void onMessage(ConsumerRecord<Integer,String> consumerRecord) throws JsonProcessingException {
        log.info("ConsumerRecord : {} ", consumerRecord );
        vendedorEventsService.processVendaEvento(consumerRecord);
    }
}
