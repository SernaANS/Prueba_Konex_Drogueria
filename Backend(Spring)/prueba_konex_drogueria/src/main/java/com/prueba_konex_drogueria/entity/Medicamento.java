package com.prueba_konex_drogueria.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "medicamentos",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre", "laboratorio"})
})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String laboratorio;

    @Column(name = "fecha_fabricacion")
    @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private LocalDateTime fechaFabricacion;

    @Column(name = "fecha_vencimiento")
    @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private LocalDateTime fechaVencimiento;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    @Column(name = "valor_unitario",columnDefinition = "NUMBER")
    private Double valorUnitario;

    private Integer estado;

    public Medicamento() {}

    public Medicamento(Long id, String nombre, String laboratorio, LocalDateTime fechaFabricacion, LocalDateTime fechaVencimiento, Integer cantidadStock, Double valorUnitario, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidadStock = cantidadStock;
        this.valorUnitario = valorUnitario;
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Medicamento that = (Medicamento) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public LocalDateTime getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDateTime fechaFabricacion) {this.fechaFabricacion = fechaFabricacion;}

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}