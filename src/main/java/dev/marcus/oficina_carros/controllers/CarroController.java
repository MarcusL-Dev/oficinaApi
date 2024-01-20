package dev.marcus.oficina_carros.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcus.oficina_carros.entities.carro.Carro;
import dev.marcus.oficina_carros.entities.carro.CarroDTO;
import dev.marcus.oficina_carros.entities.carro.CarroUpdateDTO;
import dev.marcus.oficina_carros.services.CarroService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequestMapping("/carros")
@RestController
public class CarroController {

    @Autowired
    CarroService carroService;
    
    @GetMapping()
    public ResponseEntity<List<Carro>> getAllCarros() {
        return ResponseEntity.ok().body(carroService.getAllCarros());
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<Carro> createCarro(@RequestBody @Valid CarroDTO carroData) {
        return ResponseEntity.ok().body(carroService.createCarro(carroData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> updateCarro(
        @PathVariable("id") UUID carroId,
        @RequestBody CarroUpdateDTO carroUpdateData
    ) {
        return ResponseEntity.ok().body(carroService.updateCarro(carroUpdateData, carroId));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Carro> deleteCarro(@PathVariable("id") UUID carroId){
        return ResponseEntity.ok().body(carroService.deleteCarro(carroId));
    }
}
