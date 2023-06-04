package com.prueba_konex_drogueria.exceptions.medicamento;

public class MedicamentoNotFoundNameAndLaboratoryException extends RuntimeException{

    public MedicamentoNotFoundNameAndLaboratoryException(String name, String laboratory){
        super(String.format("Medicamento with name: %s not found and laboratory: %s.", name,laboratory));
    }
}
