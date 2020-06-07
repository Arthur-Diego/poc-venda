package com.poc.Carro.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.poc.venda.model.Carro;
import com.poc.venda.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/carro")
public class CarroRestController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<Carro> save(@RequestBody Carro carro){
        return ResponseEntity.ok(carroService.save(carro));
    }

    @PutMapping
    public ResponseEntity<Carro> update(@RequestBody Carro Carro){
        return ResponseEntity.ok(carroService.save(Carro));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Carro>> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(carroService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Carro>> findAll(){
        return ResponseEntity.ok().body(carroService.findAll());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        carroService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
