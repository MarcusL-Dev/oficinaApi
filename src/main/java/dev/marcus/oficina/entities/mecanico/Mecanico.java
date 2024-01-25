package dev.marcus.oficina.entities.mecanico;

import java.util.ArrayList;
import java.util.List;

import dev.marcus.oficina.entities.funcionario.Funcionario;
import dev.marcus.oficina.entities.servico.Servico;
import jakarta.persistence.OneToMany;

public class Mecanico extends Funcionario{
    
    @OneToMany(mappedBy = "atendente")
    private List<Servico> servicos = new ArrayList<>(); 
}
