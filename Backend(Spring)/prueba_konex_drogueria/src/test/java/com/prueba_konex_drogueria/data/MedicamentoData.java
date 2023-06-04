package com.prueba_konex_drogueria.data;

import com.prueba_konex_drogueria.entity.Medicamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MedicamentoData {

    public static final Medicamento medicamento= new Medicamento(11L,"acetaminofen","MK",  LocalDateTime.of(2023,05,26,10,30,0),
            LocalDateTime.of(2023,05,26,10,30,0),
            10,100.12,1);
    public static final Medicamento medicamento1= new Medicamento(2L,"acetaminofen","MK", LocalDateTime.of(2023,05,26,10,30,0),
            LocalDateTime.of(2023,05,26,10,30,0),
            10,100.12,1);
    public static final Medicamento medicamento2= new Medicamento(35L,"acetaminofen","MK", LocalDateTime.of(2023,05,26,10,30,0),
            LocalDateTime.of(2023,05,26,10,30,0),
            10,100.12,1);
    public static final Medicamento medicamento3= new Medicamento(11L,"acetaminofen","MK", LocalDateTime.of(2023,05,26,10,30,0),
            LocalDateTime.of(2023,05,26,10,30,0),
            10,200.12,1);
}
