package dev.marcus.oficina.services;

import java.util.List;
import java.util.UUID;

import dev.marcus.oficina.entities.veiculo.Veiculo;
import dev.marcus.oficina.entities.veiculo.VeiculoDTO;
import dev.marcus.oficina.entities.veiculo.VeiculoOutDTO;
import dev.marcus.oficina.entities.veiculo.VeiculoUpdateDTO;

public interface VeiculoService {
    VeiculoOutDTO createVeiculo(VeiculoDTO veiculoData);
    List<VeiculoOutDTO> getAllVeiculos();
    Veiculo getVeiculoById(UUID veiculoId);
    Veiculo updateVeiculo(VeiculoUpdateDTO veiculoUpdateData, UUID veiculoId);
    Veiculo deleteVeiculo(UUID veiculoId);
}
