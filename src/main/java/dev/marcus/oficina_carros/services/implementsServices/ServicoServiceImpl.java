package dev.marcus.oficina_carros.services.implementsServices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.marcus.oficina_carros.entities.servico.Servico;
import dev.marcus.oficina_carros.entities.servico.ServicoDTO;
import dev.marcus.oficina_carros.entities.servico.ServicoUpdateDTO;
import dev.marcus.oficina_carros.repositories.ServicoRepository;
import dev.marcus.oficina_carros.services.CarroService;
import dev.marcus.oficina_carros.services.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    ServicoRepository servicoRepository;
    @Autowired
    CarroService carroService;

    @Override
    public Servico createServico(ServicoDTO servicoData) {
        var carro = carroService.getCarroById(servicoData.carroId());
        var newServico = new Servico(servicoData, carro);
        servicoRepository.save(newServico);
        return newServico;
    }

    @Override
    public Servico getServicoById(UUID servicoId) {
        var servico = servicoRepository.findById(servicoId);
        return servico.orElseThrow(() -> new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Servico nao encontrado com id: " + servicoId.toString()
        ));
    }

    @Override
    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }

    @Override
    public Servico updateServico(ServicoUpdateDTO servicoUpdateData, UUID servicoId) {
        var servico = getServicoById(servicoId);
        if (servicoUpdateData.carroId() != null) {
            var carro = carroService.getCarroById(servicoId);
            servico.updateServico(servicoUpdateData, carro);
        }else{
            servico.updateServico(servicoUpdateData);
        }
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
