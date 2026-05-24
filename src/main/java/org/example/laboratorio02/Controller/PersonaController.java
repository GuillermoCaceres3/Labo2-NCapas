package org.example.laboratorio02.Controller;


import jakarta.validation.Valid;
import org.example.laboratorio02.Model.DTOs.PersonaConCargosDTO;
import org.example.laboratorio02.Model.DTOs.Requests.PersonaRequestDTO;
import org.example.laboratorio02.Model.DTOs.Responses.GenericResponse;
import org.example.laboratorio02.Model.DTOs.Responses.PersonaResponseDTO;
import org.example.laboratorio02.Model.DTOs.TopBuscadoDTO;
import org.example.laboratorio02.Service.iPersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final iPersonaService personaService;

    public PersonaController(iPersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public ResponseEntity<GenericResponse> registrarPersona(@RequestBody @Valid PersonaRequestDTO request){
        return GenericResponse.builder()
                .message("Persona creada con exito")
                .data(personaService.registrarPersona(request))
                .status(HttpStatus.OK)
                .build().buildResponse();
    }

    @GetMapping("/top-3-mas-buscados")
    public ResponseEntity<List<TopBuscadoDTO>> obtenerTop3MasBuscados() {
        return ResponseEntity.ok(personaService.obtenerTop3MasBuscados());
    }

    @GetMapping("/con-cargos")
    public ResponseEntity<List<PersonaConCargosDTO>> obtenerPersonasConCargos() {
        return ResponseEntity.ok(personaService.obtenerPersonasConCargos());
    }
}
