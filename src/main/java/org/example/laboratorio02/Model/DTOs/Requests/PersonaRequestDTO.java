package org.example.laboratorio02.Model.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaRequestDTO {
    @NotBlank(message="La persona debe llevar un nombre")
    private String nombre;

    @NotBlank(message="El DUI es obligatorio")
    @Pattern(regexp = "^\\d{8}-\\d$", message="El DUI debe tener un formato específico")
    private String dui;

    @NotBlank(message="El telefono es obligatorio")
    private String telefono;

    @NotNull(message="Es necesario especificar una dirección válida")
    private Long idDireccion;
}
