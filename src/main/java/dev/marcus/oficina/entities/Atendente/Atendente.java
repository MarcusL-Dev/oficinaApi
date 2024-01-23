package dev.marcus.oficina.entities.Atendente;

import dev.marcus.oficina.entities.funcionario.Funcionario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "atendentes")
@Table(name = "atendentes")
public class Atendente extends Funcionario{

    private String password;
}
