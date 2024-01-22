package dev.marcus.oficina_carros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.oficina_carros.entities.carro.Carro;

public interface CarroRepository extends JpaRepository<Carro, UUID>{

}
