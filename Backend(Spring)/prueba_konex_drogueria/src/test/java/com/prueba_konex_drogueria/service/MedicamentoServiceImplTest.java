package com.prueba_konex_drogueria.service;

import com.prueba_konex_drogueria.data.MedicamentoData;
import com.prueba_konex_drogueria.dto.MedicamentoDTO;
import com.prueba_konex_drogueria.entity.Medicamento;
import com.prueba_konex_drogueria.exceptions.global.GlobalDataRequiredException;
import com.prueba_konex_drogueria.exceptions.medicamento.MedicamentoNotFoundException;
import com.prueba_konex_drogueria.exceptions.medicamento.MedicamentoNotFoundNameAndLaboratoryException;
import com.prueba_konex_drogueria.mapper.MedicamentoMapper;
import com.prueba_konex_drogueria.repository.MedicamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedicamentoServiceImplTest {

    @Mock
    private MedicamentoRepository medicamentoRepository;

    @InjectMocks
    private MedicamentoServiceImpl medicamentoServiceImp;


    private MedicamentoDTO medicamentoDTONull;
    private Medicamento medicamento,medicamentoUno,medicamentoDos,medicamentoTres;
    private MedicamentoDTO medicamentoDTO,medicamentoDTOUno,medicamentoDTODos,medicamentoDTOTres;

    private List<Medicamento> listAll;
    private List<MedicamentoDTO> listALlDTO;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        medicamento= MedicamentoData.medicamento;
        medicamentoUno= MedicamentoData.medicamento1;
        medicamentoDos= MedicamentoData.medicamento2;
        medicamentoTres= MedicamentoData.medicamento3;

        medicamentoDTO= MedicamentoMapper.INSTANCE.mapToDto(medicamento);
        medicamentoDTOUno= MedicamentoMapper.INSTANCE.mapToDto(medicamentoUno);
        medicamentoDTODos= MedicamentoMapper.INSTANCE.mapToDto(medicamentoDos);
        medicamentoDTOTres= MedicamentoMapper.INSTANCE.mapToDto(medicamentoTres);


        listAll= new ArrayList<>(Arrays.asList(medicamento,medicamentoUno,medicamentoDos,medicamentoTres));
        listALlDTO=new ArrayList<>(Arrays.asList(medicamentoDTO,medicamentoDTODos,medicamentoDTOTres));

    }

    @Test
    void saveMedicamento() throws IOException {
        when(medicamentoRepository.save(any(Medicamento.class))).thenReturn(medicamentoUno);
        medicamentoDTOUno= MedicamentoMapper.INSTANCE.mapToDto(medicamentoUno);
        assertEquals(medicamentoDTOUno,medicamentoServiceImp.saveMedicamento(medicamentoDTOUno));

    }

    @Test
    void saveMedicamento_GlobalException() throws IOException {
        assertThrows(GlobalDataRequiredException.class,()->medicamentoServiceImp.saveMedicamento(medicamentoDTONull));
    }

    @Test
    void getMedicamento() throws IOException {
        when(medicamentoRepository.findById(any())).thenReturn(Optional.of(medicamentoDos));
        assertEquals(medicamentoDTODos,medicamentoServiceImp.getMedicamento(medicamentoDos.getId()));
    }

    @Test
    void getMedicamentoException() throws IOException {
        assertThrows(MedicamentoNotFoundException.class,()->medicamentoServiceImp.getMedicamento(medicamentoDos.getId()));
    }


    @Test
    void getMedicamentosByNombreAndLaboratory() throws IOException  {
       when(medicamentoRepository.findByNombreAndLaboratorio(anyString(),anyString()))
                .thenReturn(Optional.of(medicamento));

        MedicamentoDTO medicamento1 =medicamentoServiceImp.getMedicamento(medicamento.getNombre(),medicamento.getLaboratorio());
        assertEquals(medicamentoDTO,medicamento1);

    }

    @Test
    void getMedicamentoNotFoundNameAndLaboratoryException() throws IOException {
        when(medicamentoRepository.findByNombreAndLaboratorio(anyString(),anyString()))
                .thenReturn(Optional.empty());
        assertThrows(MedicamentoNotFoundNameAndLaboratoryException.class, ()->medicamentoServiceImp.getMedicamento(medicamento.getNombre(),medicamento.getLaboratorio()));
    }

    @Test
    void getMedicamentos() {
        when(medicamentoRepository.findAll()).thenReturn(listAll);
        assertEquals(4,medicamentoServiceImp.getMedicamentos().size());
    }

    @Test
    void deleteMedicamento() throws IOException {
        MedicamentoDTO medicamentoDTOX = medicamentoDTOTres;
        Optional<Medicamento>  medicamentoExistente = Optional.of(medicamento);
        when(medicamentoRepository.findByNombreAndLaboratorio(medicamentoDTOX.getNombre(), medicamentoDTOX.getLaboratorio()))
                .thenReturn(medicamentoExistente);
        String result = medicamentoServiceImp.deleteMedicamento(medicamentoDTOX.getNombre(), medicamentoDTOX.getLaboratorio());
        assertEquals("Medicamento eliminado", result);
        //verify(medicamentoRepository, times(1)).deleteById(medicamentoExistente.get().getId());
    }


    @Test
    void deleteMedicamento_Exception() throws IOException {
        when(medicamentoRepository.findByNombreAndLaboratorio(anyString(), anyString()))
                .thenReturn(Optional.empty());
        assertThrows(MedicamentoNotFoundNameAndLaboratoryException.class,
                ()->medicamentoServiceImp.deleteMedicamento(anyString(), anyString()));
    }


    @Test
    void updateMedicamento() throws IOException {
        MedicamentoDTO medicamentoDTOX = medicamentoDTOTres;
        Optional<Medicamento>  medicamentoExistente = Optional.of(medicamento);

        when(medicamentoRepository.findByNombreAndLaboratorio(medicamentoDTOX.getNombre(), medicamentoDTOX.getLaboratorio()))
                .thenReturn(medicamentoExistente);

        Medicamento medicamentoNuevo = MedicamentoMapper.INSTANCE.DtoToEntity(medicamentoDTOX);
        medicamentoNuevo.setId(medicamentoExistente.get().getId());
        when(medicamentoRepository.save(medicamentoNuevo)).thenReturn(medicamentoNuevo);

        // Act
        MedicamentoDTO result = medicamentoServiceImp.updateMedicamento(medicamentoDTOX);
        assertNotNull(result);
        assertEquals(result,medicamentoDTOX);
    }

    @Test
    void updateMedicamento_Exception() throws IOException{
        when(medicamentoRepository.findByNombreAndLaboratorio(anyString(), anyString())).thenReturn(Optional.empty());
        assertThrows(MedicamentoNotFoundNameAndLaboratoryException.class,
                ()->medicamentoServiceImp.updateMedicamento(medicamentoDTO));
    }




}