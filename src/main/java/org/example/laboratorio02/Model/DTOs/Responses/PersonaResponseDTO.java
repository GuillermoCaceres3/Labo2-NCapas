package org.example.laboratorio02.Model.DTOs.Responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class PersonaResponseDTO {

    private UUID id;
    private String nombre;
    private String dui;
    private String telefono;

    private Long idDireccion;
    private String departamento;
    private String municipio;
    private String calle;
    private String colonia;
}
