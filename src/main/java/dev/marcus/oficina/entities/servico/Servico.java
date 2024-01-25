package dev.marcus.oficina.entities.servico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.marcus.oficina.entities.Atendente.Atendente;
import dev.marcus.oficina.entities.Atendente.DTOs.AtendenteOutDTO;
import dev.marcus.oficina.entities.cliente.DTOs.ClienteOutDTO;
import dev.marcus.oficina.entities.funcionario.Funcionario;
import dev.marcus.oficina.entities.servico.DTOs.ServicoDTO;
import dev.marcus.oficina.entities.servico.DTOs.ServicoOutDTO;
import dev.marcus.oficina.entities.servico.DTOs.ServicoUpdateDTO;
import dev.marcus.oficina.entities.veiculo.Veiculo;
import dev.marcus.oficina.entities.veiculo.VeiculoOutDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "servicos")
@Table(name = "servicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "tipo_Servico", nullable = false)
    private TipoServico tipoServico;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "num_dias", nullable = false)
    private int numDias;

    @Column(name = "status", nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @JsonIgnore
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "atendente_id")
    private Atendente atendente;

    public Servico(ServicoDTO servicoData, Veiculo veiculo){
        setTipoServico(servicoData.tipoServico());
        setDataInicio(servicoData.dataInicio());
        setNumDias(servicoData.numDias());
        setStatus(false);
        setVeiculo(veiculo);
    }

    public void updateServico(ServicoUpdateDTO servicoUpdateData, Veiculo veiculo){
        if(servicoUpdateData.tipoServico() != null) setTipoServico(servicoUpdateData.tipoServico());
        if(servicoUpdateData.dataInicio() != null) setDataInicio(servicoUpdateData.dataInicio());
        if(servicoUpdateData.numDias() != null) setNumDias(servicoUpdateData.numDias());
        if(servicoUpdateData.status() == false || 
            servicoUpdateData.status() == true) 
                setStatus(servicoUpdateData.status());
        if(veiculo.getPlaca() != null) setVeiculo(veiculo);
    }

    public boolean getStatus(){
        return this.status;
    }

    public ServicoOutDTO createServicoOutData(VeiculoOutDTO veiculoOutData, AtendenteOutDTO atendenteOutData){
        return new ServicoOutDTO(this, veiculoOutData, atendenteOutData);
    }
}
