package dev.marcus.oficina.services.implementsServices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcus.oficina.entities.servico.Servico;
import dev.marcus.oficina.entities.servico.ServicoDTO;
import dev.marcus.oficina.entities.servico.ServicoUpdateDTO;
import dev.marcus.oficina.entities.veiculo.Veiculo;
import dev.marcus.oficina.infra.exceptions.EntityNotFoundException;
import dev.marcus.oficina.infra.exceptions.TipoEntity;
import dev.marcus.oficina.repositories.ServicoRepository;
import dev.marcus.oficina.services.ServicoService;
import dev.marcus.oficina.services.VeiculoService;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    ServicoRepository servicoRepository;
    @Autowired
    VeiculoService veiculoService;

    @Override
    public Servico createServico(ServicoDTO servicoData) {
        var veiculo = veiculoService.getVeiculoById(servicoData.veiculoId());
        var newServico = new Servico(servicoData, veiculo);
        servicoRepository.save(newServico);
        return newServico;
    }

    @Override
    public Servico getServicoById(UUID servicoId) {
        var servico = servicoRepository.findById(servicoId);
        return servico.orElseThrow(()-> new EntityNotFoundException(TipoEntity.SERVICO, servicoId)); 

    }

    @Override
    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }

    @Override
    public Servico updateServico(ServicoUpdateDTO servicoUpdateData, UUID servicoId) {
        var servico = getServicoById(servicoId);
        var veiculo = new Veiculo();
        if (servicoUpdateData.veiculoId() != null) {
            veiculo = veiculoService.getVeiculoById(servicoUpdateData.veiculoId());
        }
        servico.updateServico(servicoUpdateData, veiculo);
        servicoRepository.save(servico);
        return servico;
    }

    @Override
    public Servico deletServico(UUID servicoId) {
        var servico = getServicoById(servicoId);
        servicoRepository.delete(servico);
        return servico;
    }
}
