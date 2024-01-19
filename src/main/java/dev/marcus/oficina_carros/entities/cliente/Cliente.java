package dev.marcus.oficina_carros.entities.cliente;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import dev.marcus.oficina_carros.entities.cliente.exceptions.IdadeInvalida;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "clientes")
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(name = "data_nasc", nullable = false)
    private LocalDate dataNasc;

    @Column(nullable = false)
    private String telefone;
    
    public void updateCliente(ClienteUpdateDTO clienteUpdateData){
        if (clienteUpdateData.nome().isPresent() && !clienteUpdateData.nome().get().isEmpty()) 
            setNome(clienteUpdateData.nome().get());
        if (clienteUpdateData.sobrenome().isPresent() && !clienteUpdateData.sobrenome().get().isEmpty()) 
            setSobrenome(clienteUpdateData.sobrenome().get());
        if (clienteUpdateData.dataNasc().isPresent() && clienteUpdateData.dataNasc().get() != null) 
            setDataNasc(clienteUpdateData.dataNasc().get());
        if (clienteUpdateData.telefone().isPresent() && !clienteUpdateData.telefone().get().isEmpty()) 
            setTelefone(clienteUpdateData.telefone().get());
    }

    public Cliente(ClienteDTO clienteData){
        setCpf(clienteData.cpf());
        setNome(clienteData.nome());
        setSobrenome(clienteData.sobrenome());
        setDataNasc(clienteData.dataNasc());
        setTelefone(clienteData.telefone());
    }

    public boolean validaIdade(LocalDate dataNasc){
        LocalDate dataHoje = LocalDate.now();
        Period periodo = Period.between(dataNasc, dataHoje);
        if (periodo.getYears() >= 18) {
            return true;
        }
        return false;
    }

    public void setDataNasc(LocalDate dataNasc){
        if (validaIdade(dataNasc)){
            this.dataNasc = dataNasc;
        }else{
            throw new IdadeInvalida("Idade invalida");
        }
    }
}
