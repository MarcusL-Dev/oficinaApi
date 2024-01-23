package dev.marcus.oficina.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.oficina.entities.servico.Servico;

public interface ServicoRepository extends JpaRepository<Servico, UUID>{

}
