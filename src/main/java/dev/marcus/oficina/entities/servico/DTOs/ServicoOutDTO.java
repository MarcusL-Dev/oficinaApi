package dev.marcus.oficina.entities.servico.DTOs;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import dev.marcus.oficina.entities.Atendente.DTOs.AtendenteOutDTO;
import dev.marcus.oficina.entities.servico.Servico;
import dev.marcus.oficina.entities.servico.TipoServico;
import dev.marcus.oficina.entities.veiculo.VeiculoOutDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ServicoOutDTO(
    UUID id,
    TipoServico tipoServico,
    LocalDate dataInicio,
    int numDias,
    boolean status,
    VeiculoOutDTO veiculoOutData,
    AtendenteOutDTO atendenteOutData
) {
    public ServicoOutDTO(Servico servico, VeiculoOutDTO veiculoOutData, AtendenteOutDTO atendenteOutData){
        this(
            servico.getId(),
            servico.getTipoServico(),
            servico.getDataInicio(),
            servico.getNumDias(),
            servico.getStatus(),
            veiculoOutData,
            atendenteOutData
        );
    }
}
