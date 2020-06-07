package com.poc.venda.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.poc.venda.domain.VendaEventIds;
import com.poc.venda.domain.VendaEventType;
import com.poc.venda.kafka.producer.ProducerGeneric;
import com.poc.venda.kafka.producer.VendaProducer;
import com.poc.venda.model.Venda;
import com.poc.venda.service.VendaService;
import com.poc.venda.utils.StringUtilsTopics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/vendas")
public class VendaRestController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ProducerGeneric producerGeneric;

    @PostMapping(value = "/venda")
    public ResponseEntity<Object> venda(@RequestBody VendaEventIds vendaEventIds) throws JsonProcessingException {
        vendaEventIds.setVendaEventType(VendaEventType.NEW);
        producerGeneric.sendEvent(vendaEventIds, StringUtilsTopics.TOPIC_VENDA_IDS);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaEventIds);
    }

    @PostMapping
    public ResponseEntity<Venda> save(@RequestBody Venda Venda){
        return ResponseEntity.ok(vendaService.save(Venda));
    }

    @PutMapping
    public ResponseEntity<Venda> update(@RequestBody Venda Venda){
        return ResponseEntity.ok(vendaService.save(Venda));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Venda>> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(vendaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Venda>> findAll(){
        return ResponseEntity.ok().body(vendaService.findAll());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        vendaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
