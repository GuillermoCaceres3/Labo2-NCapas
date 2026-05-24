package org.example.laboratorio02.Model.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class TopBuscadoDTO {

    private UUID id;
    private String nombre;
    private String dui;
    private Long cantidadCargos;
}
