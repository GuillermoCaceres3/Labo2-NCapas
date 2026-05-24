package org.example.laboratorio02.Model.DTOs.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaRequestDTO {
    private String nombre;
    private String dui;
    private String telefono;
    private Long idDireccion;
}
