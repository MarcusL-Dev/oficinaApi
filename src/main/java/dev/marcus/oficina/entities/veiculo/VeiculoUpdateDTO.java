package dev.marcus.oficina.entities.veiculo;

import java.util.UUID;

public record VeiculoUpdateDTO(

    String marca,

    String modelo,

    TipoVeiculo tipoVeiculo,

    UUID clienteId

) {
    
}
