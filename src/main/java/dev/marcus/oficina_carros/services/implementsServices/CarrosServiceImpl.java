package dev.marcus.oficina_carros.services.implementsServices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.marcus.oficina_carros.entities.carro.Carro;
import dev.marcus.oficina_carros.entities.carro.CarroDTO;
import dev.marcus.oficina_carros.entities.carro.CarroUpdateDTO;
import dev.marcus.oficina_carros.entities.cliente.Cliente;
import dev.marcus.oficina_carros.repositories.CarroRepository;
import dev.marcus.oficina_carros.services.CarroService;
import dev.marcus.oficina_carros.services.ClienteService;

@Service
public class CarrosServiceImpl implements CarroService{

    @Autowired
    CarroRepository carroRepository;
    @Autowired
    ClienteService clienteService;

    @Override
    public Carro getCarroById(UUID carroId) {
        var carro = carroRepository.findById(carroId);
        return carro.orElseThrow(() -> new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Carro não encontrado com ID:" + carroId.toString()
        ));
    }

    @Override
    public Carro createCarro(CarroDTO carroData) {
        var cliente = clienteService.getClienteById(carroData.clienteId());
        var newCarro = new Carro(carroData, cliente);
        carroRepository.save(newCarro);
        return newCarro;
    }

    @Override
    public List<Carro> getAllCarros() {
        return carroRepository.findAll();
    }

    @Override
    public Carro updateCarro(CarroUpdateDTO carroUpdateData, UUID carroId) {
        var carro = this.getCarroById(carroId);
        if (carroUpdateData.clienteId() != null) {
            var cliente = clienteService.getClienteById(carroUpdateData.clienteId());
            carro.setCliente(cliente);
            carro.updateCarro(carroUpdateData, cliente);
        }else{
            carro.updateCarro(carroUpdateData);
        }
        carroRepository.save(carro);
        return carro;
    }
    
}
