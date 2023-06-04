package com.prueba_konex_drogueria.controller;

import com.prueba_konex_drogueria.dto.VentaDTO;

import com.prueba_konex_drogueria.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api/venta")
@Validated
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Operation(summary = "Obtiene todas las Ventas")
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<VentaDTO>> getVentas() {
        return ResponseEntity.status(HttpStatus.OK).body( ventaService.getVentas());
    }

    @Operation(summary = "Crea una Venta")
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<VentaDTO> createVenta(@RequestBody VentaDTO ventaDTO) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.saveVenta(ventaDTO));
    }
}
