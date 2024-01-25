package dev.marcus.oficina.entities.veiculo;

import java.time.Year;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import dev.marcus.oficina.entities.cliente.DTOs.ClienteOutDTO;
import dev.marcus.oficina.entities.servico.DTOs.ServicoOutDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record VeiculoOutDTO(
   UUID id,
   String placa,
   Year ano,
   String marca,
   String modelo,
   TipoVeiculo tipoVeiculo,
   ClienteOutDTO clienteData,
   List<ServicoOutDTO> servicosData
) {
  
    public VeiculoOutDTO(Veiculo veiculo, ClienteOutDTO clienteData, List<ServicoOutDTO> servicosData){
        this(
            veiculo.getId(), 
            veiculo.getPlaca(), 
            veiculo.getAno(), 
            veiculo.getMarca(), 
            veiculo.getModelo(), 
            veiculo.getTipoVeiculo(), 
            clienteData, 
            servicosData
        );
    }
}
