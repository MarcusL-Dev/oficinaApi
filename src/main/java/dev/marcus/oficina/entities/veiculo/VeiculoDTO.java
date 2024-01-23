package dev.marcus.oficina.entities.veiculo;

import java.time.Year;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record VeiculoDTO(

    @NotBlank
    String placa,
    @PastOrPresent
    Year ano,
    @NotBlank
    String marca,
    @NotBlank
    String modelo,
    @NotNull
    TipoVeiculo tipoVeiculo,
    @NotNull
    UUID clienteId



) {
    
}
