package org.example.laboratorio02.Model.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CargoRequestDTO {

    @NotNull
    private LocalDate fecha;

    @NotBlank
    @Size(max = 500)
    private String descripcion;

    @NotBlank
    @Size(min = 10, max = 10)
    private String duiAcusador;

    @NotBlank
    @Size(min = 10, max = 10)
    private String duiAcusado;

    @NotNull
    private Integer tipoCargo;
}