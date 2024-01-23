package dev.marcus.oficina.infra.exceptions;

public class IdadeInvalida extends RuntimeException{
    public IdadeInvalida(){
        super("Idade invalida");
    }
}
