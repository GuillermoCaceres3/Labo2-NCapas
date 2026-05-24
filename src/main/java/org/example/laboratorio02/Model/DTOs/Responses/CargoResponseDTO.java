package org.example.laboratorio02.Model.DTOs.Responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CargoResponseDTO {

    private Long id;
    private LocalDate fecha;
    private String descripcion;
    private Integer tipoCargo;
    private String tipoCargoTexto;

    private String nombreAcusador;
    private String duiAcusador;

    private String nombreAcusado;
    private String duiAcusado;
}