package dev.marcus.oficina.entities.cliente.DTOs;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import dev.marcus.oficina.entities.cliente.Cliente;
import dev.marcus.oficina.entities.veiculo.VeiculoOutDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ClienteOutDTO(
    UUID id,
    String cpf,
    String nome,
    String sobrenome,
    LocalDate dataNasc,
    String telefone,
    List<VeiculoOutDTO> veiculosOutData
) {

    public ClienteOutDTO(Cliente cliente, List<VeiculoOutDTO> veiculosOutData){
        this(
            cliente.getId(),
            cliente.getCpf(),
            cliente.getNome(),
            cliente.getSobrenome(),
            cliente.getDataNasc(),
            cliente.getTelefone(),
            veiculosOutData
        );
        
    }

}
