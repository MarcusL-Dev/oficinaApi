package dev.marcus.oficina.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcus.oficina.entities.servico.Servico;
import dev.marcus.oficina.entities.servico.DTOs.ServicoDTO;
import dev.marcus.oficina.entities.servico.DTOs.ServicoUpdateDTO;
import dev.marcus.oficina.services.ServicoService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/servicos")
@RestController
public class ServicoController {
    
    @Autowired
    ServicoService servicoService;

    @GetMapping()
    public ResponseEntity<List<Servico>> getAllServicos() {
        return ResponseEntity.ok().body(servicoService.getAllServicos());
    }

    @PostMapping()
    public ResponseEntity<Servico> postMethodName(@RequestBody @Valid ServicoDTO servicoData) {
        return ResponseEntity.ok().body(servicoService.createServico(servicoData));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable("id") UUID servicoId) {
        return ResponseEntity.ok().body(servicoService.getServicoById(servicoId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable("id") UUID servicoId, @RequestBody ServicoUpdateDTO servicoUpdateData) {
        return ResponseEntity.ok().body(servicoService.updateServico(servicoUpdateData, servicoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> deleteServico(@PathVariable("id") UUID servicoId){
        return ResponseEntity.ok().body(servicoService.deletServico(servicoId));
    }
    
    
    
}
