package dev.marcus.oficina_carros.entities.cliente;

import java.time.LocalDate;
import java.util.Optional;

public record ClienteUpdateDTO(
    
    Optional<String> nome,

    Optional<String> sobrenome,

    Optional<LocalDate> dataNasc,

    Optional<String> telefone
) {
    
}
