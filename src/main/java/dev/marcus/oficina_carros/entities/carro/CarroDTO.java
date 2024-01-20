package dev.marcus.oficina_carros.entities.carro;

import java.time.Year;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public record CarroDTO(

    @NotBlank
    String placa,
    @PastOrPresent
    Year ano,
    @NotBlank
    String marca,
    @NotBlank
    String modelo,
    @NotBlank
    UUID clienteId

) {
    
}
