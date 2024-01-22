package dev.marcus.oficina_carros.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcus.oficina_carros.entities.cliente.Cliente;
import dev.marcus.oficina_carros.entities.cliente.ClienteDTO;
import dev.marcus.oficina_carros.entities.cliente.ClienteUpdateDTO;
import dev.marcus.oficina_carros.services.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RequestMapping("/clientes")
@RestController
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok().body(clienteService.getAllClientes());
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<Cliente> createCliente(@RequestBody @Valid ClienteDTO clienteData) {        
        return ResponseEntity.ok().body(clienteService.createCliente(clienteData));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") UUID clienteId) {
        return ResponseEntity.ok().body(clienteService.getClienteById(clienteId));
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Cliente> updateCliente(
        @PathVariable("id")
        UUID clienteId,
        @RequestBody
        ClienteUpdateDTO clienteUpdateData
        ){
            return ResponseEntity.ok().body(clienteService.updateCliente(clienteId, clienteUpdateData));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") UUID clienteId){
        return ResponseEntity.ok().body(clienteService.deleteCliente(clienteId));
    }
}
