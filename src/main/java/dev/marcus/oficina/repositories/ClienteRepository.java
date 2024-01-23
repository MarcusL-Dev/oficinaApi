package dev.marcus.oficina.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.oficina.entities.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

}
