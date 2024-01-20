package dev.marcus.oficina_carros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcus.oficina_carros.entities.servico.Servico;
import dev.marcus.oficina_carros.entities.servico.ServicoDTO;
import dev.marcus.oficina_carros.services.ServicoService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    
    
}
