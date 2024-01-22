package dev.marcus.oficina_carros.entities.carro;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.marcus.oficina_carros.entities.cliente.Cliente;
import dev.marcus.oficina_carros.entities.servico.Servico;
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
public class Carro {
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

    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL)
    private List<Servico> servicos = new ArrayList<>();

    public Carro(CarroDTO carroData, Cliente cliente){
        setAno(carroData.ano());
        setMarca(carroData.marca());
        setModelo(carroData.modelo());
        setPlaca(carroData.placa());
        setCliente(cliente);
    }

    public void updateCarro(CarroUpdateDTO carroUpdateData, Cliente cliente){
        if(carroUpdateData.marca() != null) setMarca(carroUpdateData.marca());
        if(carroUpdateData.modelo() != null) setModelo(carroUpdateData.modelo());
        setCliente(cliente);
    }

    public void updateCarro(CarroUpdateDTO carroUpdateData){
        if(carroUpdateData.marca() != null) setMarca(carroUpdateData.marca());
        if(carroUpdateData.modelo() != null) setModelo(carroUpdateData.modelo());
    }
}
