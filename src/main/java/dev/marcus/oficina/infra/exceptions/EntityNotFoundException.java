package dev.marcus.oficina.infra.exceptions;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(TipoEntity entity, UUID entityId){
        super(entity+" não encontrado com ID: "+entityId.toString());
    }
}
