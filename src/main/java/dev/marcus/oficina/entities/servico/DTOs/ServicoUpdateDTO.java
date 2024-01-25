package dev.marcus.oficina.entities.servico.DTOs;

import java.time.LocalDate;
import java.util.UUID;

import dev.marcus.oficina.entities.servico.TipoServico;

public record ServicoUpdateDTO(
    
    TipoServico tipoServico,

    LocalDate dataInicio,

    Integer numDias,

    boolean status,

    UUID veiculoId  

) {
    
}
