package dev.marcus.oficina_carros.services;

import java.util.List;
import java.util.UUID;

import dev.marcus.oficina_carros.entities.servico.Servico;
import dev.marcus.oficina_carros.entities.servico.ServicoDTO;
import dev.marcus.oficina_carros.entities.servico.ServicoUpdateDTO;

public interface ServicoService {
    Servico createServico(ServicoDTO servicoData);
    List<Servico> getAllServicos();
    Servico getServicoById(UUID servicoId);
    Servico updateServico(ServicoUpdateDTO ServicoUpdateData, UUID servicoId);
    Servico deletServico(UUID servicoId);
}
