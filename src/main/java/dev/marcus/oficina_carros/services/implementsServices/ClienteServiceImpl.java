package dev.marcus.oficina_carros.services.implementsServices;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Cliente newCliente = new Cliente(clienteData);
        return clienteRepository.save(newCliente);
    }

    @Override
    public Cliente getClienteById(UUID clienteId) {
        try {
            Optional<Cliente> cliente = clienteRepository.findById(clienteId);
            return cliente.orElseThrow(()-> new NoSuchElementException(
                "Cliente não encontrado com ID:" + clienteId.toString()
            ));
        } catch (NoSuchElementException e) {
            throw e;
        }
    }  

    @Override
    public Cliente updateCliente(UUID clienteId, ClienteUpdateDTO clienteUpdateData) {
        Cliente cliente = getClienteById(clienteId);
        cliente.updateCliente(clienteUpdateData);
        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente deleteCliente(UUID clienteId) {
        Cliente cliente = getClienteById(clienteId);
        clienteRepository.delete(cliente);
        return cliente;
    }
}
