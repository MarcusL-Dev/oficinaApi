package dev.marcus.oficina_carros.services;

import java.util.List;

import dev.marcus.oficina_carros.entities.servico.Servico;
import dev.marcus.oficina_carros.entities.servico.ServicoDTO;

public interface ServicoService {
    Servico createServico(ServicoDTO servicoData);
    List<Servico> getAllServicos();
    
}
