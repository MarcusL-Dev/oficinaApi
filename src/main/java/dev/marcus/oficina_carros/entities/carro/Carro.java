package dev.marcus.oficina_carros.entities.carro;

import java.time.Year;
import java.util.UUID;

import dev.marcus.oficina_carros.entities.cliente.Cliente;
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
    private Cliente cliente;


    public Carro(CarroDTO carroData, Cliente cliente){
        setAno(carroData.ano());
        setMarca(carroData.marca());
        setModelo(carroData.modelo());
        setPlaca(carroData.placa());
        setCliente(cliente);
    }
}
