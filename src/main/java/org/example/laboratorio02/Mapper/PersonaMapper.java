package org.example.laboratorio02.Mapper;

import org.example.laboratorio02.Model.DTOs.Responses.PersonaResponseDTO;
import org.example.laboratorio02.Model.Direccion;
import org.example.laboratorio02.Model.Persona;

public class PersonaMapper {

    public static PersonaResponseDTO toPersonaResponseDTO(Persona persona) {
        Direccion direccion = persona.getDireccion();

        return PersonaResponseDTO.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .dui(persona.getDui())
                .telefono(persona.getTelefono())
                .idDireccion(direccion.getId())
                .departamento(direccion.getDepartamento().getNombre())
                .municipio(direccion.getMunicipio().getNombre())
                .calle(direccion.getCalle())
                .colonia(direccion.getColonia())
                .build();
    }
}
