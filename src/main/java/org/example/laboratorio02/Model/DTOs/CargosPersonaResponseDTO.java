package org.example.laboratorio02.Model.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class CargosPersonaResponseDTO {

    private UUID id;
    private String nombre;
    private String dui;
    private String telefono;
    private List<CargoResponseDTO> cargos;
}