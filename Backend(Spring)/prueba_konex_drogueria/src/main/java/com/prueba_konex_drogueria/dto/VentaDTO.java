package com.prueba_konex_drogueria.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;


@Builder

public class VentaDTO {


    @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private LocalDateTime fecha;

    private MedicamentoDTO medicamento;

    private Integer cantidad;

    private BigDecimal valorUnitario;

    private BigDecimal valorTotal;

    public VentaDTO(LocalDateTime fecha, MedicamentoDTO medicamento, Integer cantidad, BigDecimal valorUnitario, BigDecimal valorTotal) {
        this.fecha = fecha;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public VentaDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaDTO ventaDTO = (VentaDTO) o;
        return fecha.equals(ventaDTO.fecha) && medicamento.equals(ventaDTO.medicamento) && cantidad.equals(ventaDTO.cantidad) && valorUnitario.equals(ventaDTO.valorUnitario) && valorTotal.equals(ventaDTO.valorTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, medicamento, cantidad, valorUnitario, valorTotal);
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public MedicamentoDTO getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(MedicamentoDTO medicamento) {
        this.medicamento = medicamento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
