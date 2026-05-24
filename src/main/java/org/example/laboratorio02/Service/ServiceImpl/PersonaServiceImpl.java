package org.example.laboratorio02.Service.ServiceImpl;

import org.example.laboratorio02.ExceptionHandler.DireccionNoEncontrada;
import org.example.laboratorio02.ExceptionHandler.UsuarioEncontrado;
import org.example.laboratorio02.Model.DTOs.PersonaConCargosDTO;
import org.example.laboratorio02.Model.DTOs.Requests.PersonaRequestDTO;
import org.example.laboratorio02.Model.DTOs.Responses.PersonaResponseDTO;
import org.example.laboratorio02.Model.DTOs.TopBuscadoDTO;
import org.example.laboratorio02.Model.Direccion;
import org.example.laboratorio02.Model.Persona;
import org.example.laboratorio02.Repository.iCargoRepository;
import org.example.laboratorio02.Repository.iDireccionRepository;
import org.example.laboratorio02.Repository.iPersonaRepository;
import org.example.laboratorio02.Service.iPersonaService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.laboratorio02.Mapper.PersonaMapper.toPersonaResponseDTO;

@Service
public class PersonaServiceImpl implements iPersonaService {

    private final iPersonaRepository personaRepository;
    private final iDireccionRepository direccionRepository;
    private final iCargoRepository cargoRepository;

    public PersonaServiceImpl(
            iPersonaRepository personaRepository,
            iDireccionRepository direccionRepository,
            iCargoRepository cargoRepository
    ) {
        this.personaRepository = personaRepository;
        this.direccionRepository = direccionRepository;
        this.cargoRepository = cargoRepository;
    }

    // No le quise mandar que ya existe el dui por que se me hace medio inseguro XD
    @Override
    public PersonaResponseDTO registrarPersona(PersonaRequestDTO request){
        if (personaRepository.existsByDui(request.getDui())){
            throw new UsuarioEncontrado("No fue posible registrar el usuario");
        }

        Direccion direccion = direccionRepository.findById(request.getIdDireccion())
                .orElseThrow(() -> new DireccionNoEncontrada(("No se encontro la direccion")));

        Persona persona = Persona.builder()
                .nombre(request.getNombre())
                .dui(request.getDui())
                .telefono(request.getTelefono())
                .direccion(direccion)
                .build();

        Persona personaGuardada = personaRepository.save(persona);

        return toPersonaResponseDTO(personaGuardada);
    }

    @Override
    public List<PersonaConCargosDTO> obtenerPersonasConCargos(){
        return cargoRepository.findPersonasConCargos()
                .stream()
                .map(persona -> PersonaConCargosDTO.builder()
                        .id(persona.getId())
                        .nombre(persona.getNombre())
                        .dui(persona.getDui())
                        .telefono(persona.getTelefono())
                        .build())
                .toList();
    }

    @Override
    public List<TopBuscadoDTO> obtenerTop3MasBuscados() {
        return cargoRepository.findTopPersonasMasBuscadas(PageRequest.of(0,3))
                .stream()
                .map(resultado -> {
                    Persona persona = (Persona) resultado[0];
                    Long cantidadCargos = (Long) resultado[1];

                    return TopBuscadoDTO.builder()
                            .id(persona.getId())
                            .nombre(persona.getNombre())
                            .dui(persona.getDui())
                            .cantidadCargos(cantidadCargos)
                            .build();
                }).toList();
    }
}


