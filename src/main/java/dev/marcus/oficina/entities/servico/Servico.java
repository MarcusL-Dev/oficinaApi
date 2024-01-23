package dev.marcus.oficina.entities.servico;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.marcus.oficina.entities.funcionario.Funcionario;
import dev.marcus.oficina.entities.veiculo.Veiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
    private boolean status = false;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    @JsonIgnore
    private Veiculo carro;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")  // Certifique-se de ajustar o nome da coluna conforme necessário
    private Funcionario funcionario;

    public Servico(ServicoDTO servicoData, Veiculo carro){
        setTipoServico(servicoData.tipoServico());
        setDataInicio(servicoData.dataInicio());
        setNumDias(servicoData.numDias());
        setCarro(carro);
    }

    public void updateServico(ServicoUpdateDTO servicoUpdateData, Veiculo carro){
        if(servicoUpdateData.tipoServico() != null) setTipoServico(servicoUpdateData.tipoServico());
        if(servicoUpdateData.dataInicio() != null) setDataInicio(servicoUpdateData.dataInicio());
        if(servicoUpdateData.numDias() != null) setNumDias(servicoUpdateData.numDias());
        if(servicoUpdateData.status() == false || 
            servicoUpdateData.status() == true) 
                setStatus(servicoUpdateData.status());
        if(carro.getPlaca() != null) setCarro(carro);
    }


}
