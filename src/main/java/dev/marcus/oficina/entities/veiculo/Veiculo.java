package dev.marcus.oficina.entities.veiculo;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.marcus.oficina.entities.cliente.Cliente;
import dev.marcus.oficina.entities.servico.Servico;
import jakarta.persistence.CascadeType;
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

@Entity(name = "carros")
@Table(name = "carros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private Year ano;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private TipoVeiculo tipoVeiculo;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL)
    private List<Servico> servicos = new ArrayList<>();

    public Veiculo(VeiculoDTO veiculoData, Cliente cliente){
        setAno(veiculoData.ano());
        setMarca(veiculoData.marca());
        setModelo(veiculoData.modelo());
        setPlaca(veiculoData.placa());
        setTipoVeiculo(veiculoData.tipoVeiculo());
        setCliente(cliente);
    }

    public void updateVeiculo(VeiculoUpdateDTO veiculoUpdateData, Cliente cliente){
        if(veiculoUpdateData.marca() != null) setMarca(veiculoUpdateData.marca());
        if(veiculoUpdateData.modelo() != null) setModelo(veiculoUpdateData.modelo());
        if(veiculoUpdateData.tipoVeiculo() != null) setTipoVeiculo(veiculoUpdateData.tipoVeiculo());
        if(cliente.getCpf() != null) setCliente(cliente);
    }
}
