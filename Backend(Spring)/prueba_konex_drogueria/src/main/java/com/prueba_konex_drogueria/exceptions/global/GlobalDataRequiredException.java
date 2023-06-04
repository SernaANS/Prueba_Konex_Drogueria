package com.prueba_konex_drogueria.exceptions.global;

public class GlobalDataRequiredException extends  RuntimeException {

    public GlobalDataRequiredException (){
        super(String.format("enter all the required data"));
    }
}
