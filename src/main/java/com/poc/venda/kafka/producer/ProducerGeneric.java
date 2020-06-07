package com.poc.venda.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

public interface ProducerGeneric {
    public ListenableFuture<SendResult<Integer,String>> sendEvent(ProducerCommon producerObject, String topic) throws JsonProcessingException;
}
