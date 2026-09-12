package com.cofrin.api.exception;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, UUID id) {
        super(resource + " não encontrado(a) com id " + id);
    }

}
