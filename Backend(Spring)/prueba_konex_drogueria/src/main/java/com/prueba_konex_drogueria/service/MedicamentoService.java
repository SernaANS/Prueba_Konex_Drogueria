package com.prueba_konex_drogueria.service;

import com.prueba_konex_drogueria.dto.MedicamentoDTO;

import java.io.IOException;
import java.util.List;


public interface MedicamentoService {

    MedicamentoDTO saveMedicamento(MedicamentoDTO medicamento)throws IOException;

    MedicamentoDTO getMedicamento(Long id)throws IOException;

    MedicamentoDTO getMedicamento(String name,String laboratory)throws IOException;

    List<MedicamentoDTO> getMedicamentos();

    String deleteMedicamento(String name,String laboratory)throws IOException;

    MedicamentoDTO updateMedicamento(MedicamentoDTO medicamentoDTO) throws IOException;



}
