package dev.marcus.oficina_carros.services.implementsServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.marcus.oficina_carros.entities.carro.Carro;
import dev.marcus.oficina_carros.entities.carro.CarroDTO;
import dev.marcus.oficina_carros.entities.cliente.Cliente;
import dev.marcus.oficina_carros.repositories.CarroRepository;
import dev.marcus.oficina_carros.services.CarroService;
import dev.marcus.oficina_carros.services.ClienteService;

public class CarrosServiceImpl implements CarroService{

    @Autowired
    CarroRepository carroRepository;
    @Autowired
    ClienteService clienteService;

    @Override
    public Carro createCarro(CarroDTO carroData) {
        Cliente cliente = clienteService.getClienteById(carroData.clienteId());
        Carro newCarro = new Carro(carroData, cliente);
        carroRepository.save(newCarro);
        return newCarro;
    }

    @Override
    public List<Carro> getAllCarros() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCarros'");
    }
    
}
