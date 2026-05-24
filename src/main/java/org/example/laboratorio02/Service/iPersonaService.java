package org.example.laboratorio02.Service;

import org.example.laboratorio02.Model.DTOs.PersonaConCargosDTO;
import org.example.laboratorio02.Model.DTOs.Requests.PersonaRequestDTO;
import org.example.laboratorio02.Model.DTOs.Responses.PersonaResponseDTO;
import org.example.laboratorio02.Model.DTOs.TopBuscadoDTO;

import java.util.List;

public interface iPersonaService {

    PersonaResponseDTO registrarPersona(PersonaRequestDTO request);

    List<PersonaConCargosDTO> obtenerPersonasConCargos();

    List<TopBuscadoDTO> obtenerTop3MasBuscados();
}
