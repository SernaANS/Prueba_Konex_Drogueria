package com.prueba_konex_drogueria.exceptions.venta;

public class VentaNotFoundException extends RuntimeException{

    public VentaNotFoundException(Long id){
        super(String.format("Venta with ID: %s not found.", id));
    }
}
