package org.example.laboratorio02.Model.DTOs.Requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CargoRequestDTO {

    private LocalDate fecha;
    private String descripcion;
    private String duiAcusador;
    private String duiAcusado;
    private Integer tipoCargo;
}