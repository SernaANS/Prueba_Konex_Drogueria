package com.prueba_konex_drogueria.service;


import com.prueba_konex_drogueria.dto.VentaDTO;
import com.prueba_konex_drogueria.entity.Venta;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface VentaService {

     VentaDTO saveVenta(VentaDTO ventaDTO) throws IOException;

     /*VentaDTO getVenta(Long id) throws IOException;

      */

     List<VentaDTO> getVentas();

}
