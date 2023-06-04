package com.prueba_konex_drogueria.service;

import com.prueba_konex_drogueria.data.MedicamentoData;
import com.prueba_konex_drogueria.dto.MedicamentoDTO;
import com.prueba_konex_drogueria.dto.VentaDTO;
import com.prueba_konex_drogueria.entity.Medicamento;
import com.prueba_konex_drogueria.entity.Venta;
import com.prueba_konex_drogueria.exceptions.medicamento.MedicamentoNotFoundNameAndLaboratoryException;
import com.prueba_konex_drogueria.mapper.MedicamentoMapper;
import com.prueba_konex_drogueria.mapper.VentaMapper;
import com.prueba_konex_drogueria.repository.MedicamentoRepository;
import com.prueba_konex_drogueria.repository.VentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class VentaServiceImplTest {

    @Mock
    private VentaRepository ventaRepository;

    @Mock
    private MedicamentoRepository medicamentoRepository;

    @InjectMocks
    private VentaServiceImpl ventaService;

    private Medicamento medicamento;
    private MedicamentoDTO medicamentoDTO;
    private Venta venta, ventaTwo;
    private VentaDTO ventaDTO,ventaDTOTwo;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        medicamento= MedicamentoData.medicamento;
        medicamentoDTO= MedicamentoMapper.INSTANCE.mapToDto(medicamento);

        venta= new Venta(10L,
                LocalDateTime.of(2023,05,26,10,30,0),
                medicamento,
                10,
                new BigDecimal(10),
                new BigDecimal(10));

        ventaTwo= new Venta(11L,
                LocalDateTime.of(2023,05,26,10,30,0),
                medicamento,
                10,
                new BigDecimal(10),
                new BigDecimal(20));

        ventaDTO= new VentaDTO(
                LocalDateTime.of(2023,05,26,10,30,0),
                medicamentoDTO,
                10,
                new BigDecimal(10),
                new BigDecimal(10));

        ventaDTOTwo= new VentaDTO(
                LocalDateTime.of(2023,05,26,10,30,0),
                medicamentoDTO,
                10,
                new BigDecimal(10),
                new BigDecimal(20));


    }

    @Test
    void saveVenta_succes() throws IOException {

        // Arrange
        when(medicamentoRepository.findByNombreAndLaboratorio(medicamento.getNombre(), medicamento.getLaboratorio()))
                .thenReturn(Optional.of(medicamento));

        Venta venta= VentaMapper.INSTANCE.DtoToEntity(ventaDTO);
        when(ventaRepository.save(any())).thenReturn(venta);

        // Act
        VentaDTO result = ventaService.saveVenta(ventaDTO);

        // Assert
        assertNotNull(result);
        assertEquals(result,VentaMapper.INSTANCE.mapToDto(venta));
    }

    @Test
    void saveVenta_exception() throws IOException  {
        when(medicamentoRepository.findByNombreAndLaboratorio(anyString(), anyString())).thenReturn(Optional.empty());
        // Act & Assert
        assertThrows(MedicamentoNotFoundNameAndLaboratoryException.class, () -> ventaService.saveVenta(ventaDTO));
    }


    @Test
    void getVentas() {
        List<VentaDTO> ventasDTO= new ArrayList<>(Arrays.asList(ventaDTO,ventaDTOTwo));
        List<Venta> ventas= new ArrayList<>(Arrays.asList(venta,ventaTwo));
        when(ventaRepository.findAll()).thenReturn(ventas);
        assertEquals(2,ventaService.getVentas().size());
    }
}