package dev.marcus.oficina.entities.Atendente;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.marcus.oficina.entities.Atendente.DTOs.AtendenteOutDTO;
import dev.marcus.oficina.entities.funcionario.Funcionario;
import dev.marcus.oficina.entities.servico.Servico;
import dev.marcus.oficina.entities.servico.DTOs.ServicoOutDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "atendentes")
@Table(name = "atendentes")
public class Atendente extends Funcionario{

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "atendente")
    private List<Servico> servicos = new ArrayList<>();


    public AtendenteOutDTO createAtendenteOutData(List<ServicoOutDTO> servicosOutData){
        return new AtendenteOutDTO(this, servicosOutData);
    }
}
