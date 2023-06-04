package com.prueba_konex_drogueria.service;

import com.prueba_konex_drogueria.dto.VentaDTO;
import com.prueba_konex_drogueria.entity.Medicamento;
import com.prueba_konex_drogueria.entity.Venta;
import com.prueba_konex_drogueria.exceptions.medicamento.MedicamentoNotFoundNameAndLaboratoryException;
import com.prueba_konex_drogueria.exceptions.medicamento.MedicamentoNotFoundException;
import com.prueba_konex_drogueria.mapper.VentaMapper;
import com.prueba_konex_drogueria.repository.MedicamentoRepository;
import com.prueba_konex_drogueria.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public VentaDTO saveVenta(VentaDTO ventaDTO) throws IOException {
        Optional<Medicamento> medicamento=medicamentoRepository.findByNombreAndLaboratorio(ventaDTO.getMedicamento().getNombre(), ventaDTO.getMedicamento().getLaboratorio());
        if(!medicamento.isPresent()){
            throw new MedicamentoNotFoundNameAndLaboratoryException(ventaDTO.getMedicamento().getNombre(), ventaDTO.getMedicamento().getLaboratorio());}


        medicamento.get().setCantidadStock(medicamento.get().getCantidadStock()-ventaDTO.getCantidad());
        medicamentoRepository.save(medicamento.get());

        Venta venta=VentaMapper.INSTANCE.DtoToEntity(ventaDTO);
        venta.setMedicamento(medicamento.get());
        ventaRepository.save(venta);

        return ventaDTO;
    }


    public List<VentaDTO> getVentas(){
        return  VentaMapper.INSTANCE.mapToDto(ventaRepository.findAll());
    }
}
