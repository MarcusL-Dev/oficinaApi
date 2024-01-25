package dev.marcus.oficina.entities.Atendente.DTOs;

import java.util.List;
import java.util.UUID;

import dev.marcus.oficina.entities.Atendente.Atendente;
import dev.marcus.oficina.entities.servico.DTOs.ServicoOutDTO;

public record AtendenteOutDTO(
    UUID id,
    String cpf,
    String nome,
    String sobrenome,
    List<ServicoOutDTO> servicosOutData
){
    public AtendenteOutDTO(Atendente atendente, List<ServicoOutDTO> servicosOutData){
        this(
            atendente.getId(),
            atendente.getCpf(),
            atendente.getNome(),
            atendente.getSobrenome(),
            servicosOutData
        );
    }

}
