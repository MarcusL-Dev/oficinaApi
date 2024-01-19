package dev.marcus.oficina_carros.services;

import java.util.List;
import java.util.UUID;

import dev.marcus.oficina_carros.entities.cliente.Cliente;
import dev.marcus.oficina_carros.entities.cliente.ClienteDTO;
import dev.marcus.oficina_carros.entities.cliente.ClienteUpdateDTO;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Cliente createCliente(ClienteDTO clienteData);
    Cliente getClienteById(UUID clienteId);
    Cliente updateCliente(UUID clienteId, ClienteUpdateDTO clienteUpdateData);
    Cliente deleteCliente(UUID clienteId);
}
