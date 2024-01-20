package dev.marcus.oficina_carros.entities.carro;

import java.util.UUID;

public record CarroUpdateDTO(

    String marca,

    String modelo,

    UUID clienteId

) {
    
}
