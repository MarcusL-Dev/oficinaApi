package dev.marcus.oficina.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.oficina.entities.veiculo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID>{

}
