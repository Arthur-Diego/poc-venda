package com.poc.venda.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.venda.domain.VendaEventIds;
import com.poc.venda.model.Venda;
import com.poc.venda.repository.EntityBaseRepository;
import com.poc.venda.repository.EntityBaseRepositoryImpl;
import com.poc.venda.repository.LibraryEventsRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
public class VendaServiceImplEvent extends EntityBaseRepositoryImpl<Venda, Long>
        implements VendaService{

    public VendaServiceImplEvent(EntityBaseRepository<Venda, Long> entityBaseRepository) {
        super(entityBaseRepository);
    }

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate<Integer,String> kafkaTemplate;

    @Autowired
    private LibraryEventsRepository libraryEventsRepository;

    @Override
    public void processVendaEvento(ConsumerRecord<Integer,String> consumerRecord) throws JsonProcessingException {
        VendaEventIds vendaEventIds = objectMapper.readValue(consumerRecord.value(), VendaEventIds.class);
        log.info("libraryEvent : {} ", vendaEventIds);

        if(vendaEventIds.getVendaEventId()!=null && vendaEventIds.getVendaEventId()==000){
            throw new RecoverableDataAccessException("Temporary Network Issue");
        }
        save(vendaEventIds);
    }

    private void save(VendaEventIds vendaEventIds) {
        libraryEventsRepository.save(vendaEventIds);
        log.info("Successfully Persisted the libary Event {} ", vendaEventIds);
    }

    @Override
    public void handleRecovery(ConsumerRecord<Integer,String> record){

        Integer key = record.key();
        String message = record.value();

        ListenableFuture<SendResult<Integer,String>> listenableFuture = kafkaTemplate.sendDefault(key, message);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, message, ex);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key, message, result);
            }
        });
    }

    private void handleFailure(Integer key, String value, Throwable ex) {
        log.error("Error Sending the Message and the exception is {}", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}", throwable.getMessage());
        }
    }

    private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, result.getRecordMetadata().partition());
    }
}
