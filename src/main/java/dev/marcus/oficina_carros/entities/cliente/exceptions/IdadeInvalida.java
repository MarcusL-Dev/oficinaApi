package dev.marcus.oficina_carros.entities.cliente.exceptions;

public class IdadeInvalida extends RuntimeException{
    public IdadeInvalida(String message){
        super(message);
    }
}
