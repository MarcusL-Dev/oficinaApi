package dev.marcus.oficina.entities.servico.DTOs;

import java.time.LocalDate;
import java.util.UUID;

import dev.marcus.oficina.entities.servico.TipoServico;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

public record ServicoDTO (

    @NotNull
    TipoServico tipoServico,

    @NotNull
    @FutureOrPresent
    LocalDate dataInicio,

    @NotNull
    int numDias,

    @NotNull
    UUID veiculoId

){
    
}
