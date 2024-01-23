package dev.marcus.oficina.entities.servico;

import java.time.LocalDate;
import java.util.UUID;

public record ServicoUpdateDTO(
    
    TipoServico tipoServico,

    LocalDate dataInicio,

    Integer numDias,

    boolean status,

    UUID veiculoId  

) {
    
}
