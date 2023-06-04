package com.prueba_konex_drogueria.controller;

import com.prueba_konex_drogueria.dto.MedicamentoDTO;
import io.swagger.v3.oas.annotations.Operation;
import com.prueba_konex_drogueria.service.MedicamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api/medicamentos")
public class MedicamentosController {

    @Autowired
    private MedicamentoService medicamentoService;

    @Operation(summary = "Busca todos los medicamentos")
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<MedicamentoDTO>> getAllMedicamentos(){
        return ResponseEntity.status(HttpStatus.OK).body( medicamentoService.getMedicamentos());
    }

    @Operation(summary = "Busca por id")
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<MedicamentoDTO> getMedicamentoById(@PathVariable("id") Long id) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.getMedicamento(id));

    }

    @Operation(summary = "Busca por el medicamento por nombre y laboartorio")
    @GetMapping("/{nombre}/{laboratorio}")
    @ResponseBody
    public ResponseEntity<MedicamentoDTO> getMedicamentoById(@PathVariable("nombre") String nombre,@PathVariable("laboratorio") String laboratorio) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.getMedicamento(nombre,laboratorio));
    }


    @Operation(summary = "Crea un medicamento")
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<MedicamentoDTO> createMedicamento(@RequestBody MedicamentoDTO medicamentoDTO) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicamentoService.saveMedicamento(medicamentoDTO));
    }


    @Operation(summary = "Modifica el medicamento ingresado por ID")
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<MedicamentoDTO> updateMedicamento( @RequestBody MedicamentoDTO medicamentoDto) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.updateMedicamento(medicamentoDto));
    }

    @Operation(summary = "Elimina el medicamento ingresado por ID")
    @DeleteMapping("/{nombre}/{laboratorio}")
    @ResponseBody
    public ResponseEntity<String> deleteMedicamento(@PathVariable("nombre") String nombre,@PathVariable("laboratorio")String laboratorio ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.deleteMedicamento(nombre,laboratorio));
    }
}
