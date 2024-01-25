package dev.marcus.oficina.entities.Pessoa;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 65)
    private String sobrenome;

    @Column(name = "data_nasc", nullable = false)
    private LocalDate dataNasc;

    @Column(nullable = false)
    private String telefone;
}
