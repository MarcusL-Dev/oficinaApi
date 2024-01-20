package dev.marcus.oficina_carros.entities.cliente;

import java.time.LocalDate;

public record ClienteUpdateDTO(
    
    String nome,

    String sobrenome,

    LocalDate dataNasc,

    String telefone

) {
    
}
