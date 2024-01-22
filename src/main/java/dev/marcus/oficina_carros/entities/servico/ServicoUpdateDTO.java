package dev.marcus.oficina_carros.entities.servico;

import java.time.LocalDate;
import java.util.UUID;

public record ServicoUpdateDTO(
    
    TipoServico tipoServico,

    LocalDate dataInicio,

    Integer numDias,

    boolean status,

    UUID carroId  

) {
    
}
