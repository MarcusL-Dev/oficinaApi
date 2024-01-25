package dev.marcus.oficina.entities.cliente.DTOs;

import java.time.LocalDate;

public record ClienteUpdateDTO(
    
    String nome,

    String sobrenome,

    LocalDate dataNasc,

    String telefone

) {
    
}
