package dev.marcus.oficina_carros.services;

import java.util.List;
import java.util.UUID;

import dev.marcus.oficina_carros.entities.carro.Carro;
import dev.marcus.oficina_carros.entities.carro.CarroDTO;
import dev.marcus.oficina_carros.entities.carro.CarroUpdateDTO;

public interface CarroService {
    Carro createCarro(CarroDTO carroData);
    List<Carro> getAllCarros();
    Carro getCarroById(UUID carroId);
    Carro updateCarro(CarroUpdateDTO carroUpdateData ,UUID carroId);
}
