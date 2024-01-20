package dev.marcus.oficina_carros.services.implementsServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcus.oficina_carros.entities.servico.Servico;
import dev.marcus.oficina_carros.entities.servico.ServicoDTO;
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
    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }

    

}
