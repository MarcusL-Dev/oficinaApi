package dev.marcus.oficina.entities.cliente;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dev.marcus.oficina.entities.Pessoa.Pessoa;
import dev.marcus.oficina.entities.cliente.DTOs.ClienteDTO;
import dev.marcus.oficina.entities.cliente.DTOs.ClienteOutDTO;
import dev.marcus.oficina.entities.cliente.DTOs.ClienteUpdateDTO;
import dev.marcus.oficina.entities.servico.DTOs.ServicoOutDTO;
import dev.marcus.oficina.entities.veiculo.Veiculo;
import dev.marcus.oficina.entities.veiculo.VeiculoOutDTO;
import dev.marcus.oficina.infra.exceptions.IdadeInvalida;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "clientes")
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Pessoa{

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos = new ArrayList<>();

    public Cliente(ClienteDTO clienteData){
        setCpf(clienteData.cpf());
        setNome(clienteData.nome());
        setSobrenome(clienteData.sobrenome());
        setDataNasc(clienteData.dataNasc());
        setTelefone(clienteData.telefone());
    }
    
    public void updateCliente(ClienteUpdateDTO clienteUpdateData){
        if (clienteUpdateData.nome() != null) setNome(clienteUpdateData.nome());
        if (clienteUpdateData.sobrenome() != null) setSobrenome(clienteUpdateData.sobrenome());
        if (clienteUpdateData.dataNasc() != null) setDataNasc(clienteUpdateData.dataNasc());
        if (clienteUpdateData.telefone() != null) setTelefone(clienteUpdateData.telefone());
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
            setDataNasc(dataNasc);
        }else{
            throw new IdadeInvalida();
        }
    }

    public ClienteOutDTO createClienteOutData(List<VeiculoOutDTO> veiculoOutData){
        return new ClienteOutDTO(this, veiculoOutData);
    }
}
