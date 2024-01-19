package dev.marcus.oficina_carros.services;

import java.util.List;

import dev.marcus.oficina_carros.entities.carro.Carro;
import dev.marcus.oficina_carros.entities.carro.CarroDTO;

public interface CarroService {
    Carro createCarro(CarroDTO carroData);
    List<Carro> getAllCarros();
}
