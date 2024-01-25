package dev.marcus.oficina.services.implementsServices;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcus.oficina.entities.cliente.Cliente;
import dev.marcus.oficina.entities.servico.Servico;
import dev.marcus.oficina.entities.servico.DTOs.ServicoOutDTO;
import dev.marcus.oficina.entities.veiculo.Veiculo;
import dev.marcus.oficina.entities.veiculo.VeiculoDTO;
import dev.marcus.oficina.entities.veiculo.VeiculoOutDTO;
import dev.marcus.oficina.entities.veiculo.VeiculoUpdateDTO;
import dev.marcus.oficina.infra.exceptions.EntityNotFoundException;
import dev.marcus.oficina.infra.exceptions.TipoEntity;
import dev.marcus.oficina.repositories.VeiculoRepository;
import dev.marcus.oficina.services.VeiculoService;
import dev.marcus.oficina.services.ClienteService;

@Service
public class VeiculoServiceImpl implements VeiculoService{

    @Autowired
    VeiculoRepository veiculoRepository;
    @Autowired
    ClienteService clienteService;

    @Override
    public Veiculo getVeiculoById(UUID veiculoId) {
        var veiculo = veiculoRepository.findById(veiculoId);
        return veiculo.orElseThrow(()-> new EntityNotFoundException(TipoEntity.VEICULO, veiculoId));
    }

    @Override
    public VeiculoOutDTO createVeiculo(VeiculoDTO veiculoData) {
        var cliente = clienteService.getClienteById(veiculoData.clienteId());
        var newVeiculo = new Veiculo(veiculoData, cliente);
        veiculoRepository.save(newVeiculo);

        var clienteOutData = cliente.createClienteOutData(null);
        return newVeiculo.createVeiculoOutData(clienteOutData, null);
    }

    @Override
    public List<VeiculoOutDTO> getAllVeiculos() {
        var veiculos =  veiculoRepository.findAll();
        List<VeiculoOutDTO> veiculosOutData = new ArrayList<>();

        for(Veiculo veiculo : veiculos){
            List<ServicoOutDTO> servicosOutData = new ArrayList<>();

            for(Servico servico : veiculo.getServicos()){

                var atendenteOutData = servico.getAtendente().createAtendenteOutData(null);
                var servicoOutData = servico.createServicoOutData(null, atendenteOutData);

                servicosOutData.add(servicoOutData);
            }

            var clienteOutData = veiculo.getCliente().createClienteOutData(null);
            var veiculoOutData = veiculo.createVeiculoOutData(clienteOutData, servicosOutData);
            veiculosOutData.add(veiculoOutData);
        }

        return veiculosOutData;
    }

    @Override
    public Veiculo updateVeiculo(VeiculoUpdateDTO veiculoUpdateData, UUID veiculoId) {
        var veiculo = this.getVeiculoById(veiculoId);
        var cliente = new Cliente();
        if (veiculoUpdateData.clienteId() != null) {
            cliente = clienteService.getClienteById(veiculoUpdateData.clienteId());
        }
        veiculo.updateVeiculo(veiculoUpdateData, cliente);
        veiculoRepository.save(veiculo);
        return veiculo;
    }

    @Override
    public Veiculo deleteVeiculo(UUID veiculoId) {
        var veiculo = this.getVeiculoById(veiculoId);
        veiculoRepository.delete(veiculo);
        return veiculo;
    }
    
}
