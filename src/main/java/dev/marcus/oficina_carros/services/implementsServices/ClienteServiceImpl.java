package dev.marcus.oficina_carros.services.implementsServices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.marcus.oficina_carros.entities.cliente.Cliente;
import dev.marcus.oficina_carros.entities.cliente.ClienteDTO;
import dev.marcus.oficina_carros.entities.cliente.ClienteUpdateDTO;
import dev.marcus.oficina_carros.repositories.ClienteRepository;
import dev.marcus.oficina_carros.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente createCliente(ClienteDTO clienteData) {
        var newCliente = new Cliente(clienteData);
        return clienteRepository.save(newCliente);
    }

    @Override
    public Cliente getClienteById(UUID clienteId) {
        var cliente = clienteRepository.findById(clienteId);
        return cliente.orElseThrow(()-> new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Cliente não encontrado com ID:" + clienteId.toString()
        )); 
    }  

    @Override
    public Cliente updateCliente(UUID clienteId, ClienteUpdateDTO clienteUpdateData) {
        var cliente = getClienteById(clienteId);
        cliente.updateCliente(clienteUpdateData);
        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente deleteCliente(UUID clienteId) {
        var cliente = getClienteById(clienteId);
        clienteRepository.delete(cliente);
        return cliente;
    }
}
