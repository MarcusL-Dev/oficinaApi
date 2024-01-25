package dev.marcus.oficina.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcus.oficina.entities.veiculo.Veiculo;
import dev.marcus.oficina.entities.veiculo.VeiculoDTO;
import dev.marcus.oficina.entities.veiculo.VeiculoOutDTO;
import dev.marcus.oficina.entities.veiculo.VeiculoUpdateDTO;
import dev.marcus.oficina.services.VeiculoService;
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


@RequestMapping("veiculos")
@RestController
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;
    
    @GetMapping()
    public ResponseEntity<List<VeiculoOutDTO>> getAllVeiculos() {
        return ResponseEntity.ok().body(veiculoService.getAllVeiculos());
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<VeiculoOutDTO> createVeiculo(@RequestBody @Valid VeiculoDTO veiculoData) {
        return ResponseEntity.ok().body(veiculoService.createVeiculo(veiculoData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(
        @PathVariable("id") UUID veiculoId,
        @RequestBody VeiculoUpdateDTO veiculoUpdateData
    ) {
        return ResponseEntity.ok().body(veiculoService.updateVeiculo(veiculoUpdateData, veiculoId));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> deleteVeiculo(@PathVariable("id") UUID veiculoId){
        return ResponseEntity.ok().body(veiculoService.deleteVeiculo(veiculoId));
    }
}
