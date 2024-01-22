package dev.marcus.oficina_carros.entities.cliente;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record ClienteDTO(

    @CPF
    String cpf,
    @NotBlank
    String nome,
    @NotBlank
    String sobrenome,
    @Past
    LocalDate dataNasc,
    @NotBlank
    String telefone

) {
    
}
