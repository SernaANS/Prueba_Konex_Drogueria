package com.prueba_konex_drogueria.exceptions;

public class ApiRequestException extends RuntimeException{

    public ApiRequestException(String message) {
        super(message);
    }
}
