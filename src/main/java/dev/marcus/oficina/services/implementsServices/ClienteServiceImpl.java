package dev.marcus.oficina.services.implementsServices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcus.oficina.entities.cliente.Cliente;
import dev.marcus.oficina.entities.cliente.ClienteDTO;
import dev.marcus.oficina.entities.cliente.ClienteUpdateDTO;
import dev.marcus.oficina.infra.exceptions.EntityNotFoundException;
import dev.marcus.oficina.infra.exceptions.TipoEntity;
import dev.marcus.oficina.repositories.ClienteRepository;
import dev.marcus.oficina.services.ClienteService;

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
        return cliente.orElseThrow(()-> new EntityNotFoundException(TipoEntity.CLIENTE, clienteId)); 
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
