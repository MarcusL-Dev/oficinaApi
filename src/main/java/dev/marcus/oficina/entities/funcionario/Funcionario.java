package dev.marcus.oficina.entities.funcionario;

import dev.marcus.oficina.entities.Pessoa.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa{

}
