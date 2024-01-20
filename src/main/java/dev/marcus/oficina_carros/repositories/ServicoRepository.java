package dev.marcus.oficina_carros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.oficina_carros.entities.servico.Servico;

public interface ServicoRepository extends JpaRepository<Servico, UUID>{
    
}
