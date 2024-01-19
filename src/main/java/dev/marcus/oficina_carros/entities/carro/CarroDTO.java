package dev.marcus.oficina_carros.entities.carro;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record CarroDTO(

    @NotBlank
    String placa,
    @NotBlank
    String marca,
    @NotBlank
    String modelo,
    @NotBlank
    UUID clienteId

) {
    
}
