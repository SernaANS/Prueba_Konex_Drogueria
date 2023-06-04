package com.prueba_konex_drogueria.exceptions.medicamento;

public class MedicamentoNotFoundException extends RuntimeException{

    public MedicamentoNotFoundException(Long id){
        super(String.format("Medicamento with ID: %s not found.", id));
    }
}
