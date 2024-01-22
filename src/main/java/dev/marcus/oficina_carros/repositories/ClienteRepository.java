package dev.marcus.oficina_carros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.marcus.oficina_carros.entities.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

}
