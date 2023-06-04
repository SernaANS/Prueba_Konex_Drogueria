package com.prueba_konex_drogueria.mapper;

import com.prueba_konex_drogueria.dto.MedicamentoDTO;
import com.prueba_konex_drogueria.entity.Medicamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicamentoMapper {

    MedicamentoMapper INSTANCE= Mappers.getMapper(MedicamentoMapper.class);

    Medicamento DtoToEntity(MedicamentoDTO medicamentoDTO);

    MedicamentoDTO mapToDto(Medicamento medicamento);

    List<MedicamentoDTO> mapToDto(List<Medicamento> medicamentos);

}
