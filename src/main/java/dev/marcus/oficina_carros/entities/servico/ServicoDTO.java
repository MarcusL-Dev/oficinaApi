package dev.marcus.oficina_carros.entities.servico;

import java.time.LocalDate;
import java.util.UUID;

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
    UUID carroId

){
    
}
