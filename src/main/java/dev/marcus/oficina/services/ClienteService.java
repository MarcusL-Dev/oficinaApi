package dev.marcus.oficina.services;

import java.util.List;
import java.util.UUID;

import dev.marcus.oficina.entities.cliente.Cliente;
import dev.marcus.oficina.entities.cliente.ClienteDTO;
import dev.marcus.oficina.entities.cliente.ClienteUpdateDTO;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Cliente createCliente(ClienteDTO clienteData);
    Cliente getClienteById(UUID clienteId);
    Cliente updateCliente(UUID clienteId, ClienteUpdateDTO clienteUpdateData);
    Cliente deleteCliente(UUID clienteId);
}
