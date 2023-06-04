package com.prueba_konex_drogueria.mapper;

import com.prueba_konex_drogueria.dto.VentaDTO;
import com.prueba_konex_drogueria.entity.Venta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VentaMapper {

    VentaMapper INSTANCE= Mappers.getMapper(VentaMapper.class);

    Venta DtoToEntity(VentaDTO ventaDTO);

    VentaDTO mapToDto(Venta venta);

    List<VentaDTO> mapToDto(List<Venta> ventas);
}
