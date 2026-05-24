package org.example.laboratorio02.Service.ServiceImpl;

import org.example.laboratorio02.Model.Cargo;
import org.example.laboratorio02.Model.Persona;
import org.example.laboratorio02.Model.DTOs.CargoRequestDTO;
import org.example.laboratorio02.Model.DTOs.CargoResponseDTO;
import org.example.laboratorio02.Model.DTOs.CargosPersonaResponseDTO;
import org.example.laboratorio02.Repository.iCargoRepository;
import org.example.laboratorio02.Repository.iPersonaRepository;
import org.example.laboratorio02.Service.iCargoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CargoServiceImpl implements iCargoService {

    private final iPersonaRepository personaRepository;
    private final iCargoRepository cargoRepository;

    public CargoServiceImpl(iPersonaRepository personaRepository, iCargoRepository cargoRepository) {
	this.personaRepository = personaRepository;
	this.cargoRepository = cargoRepository;
    }

    @Override
    public CargoResponseDTO registrarCargo(CargoRequestDTO request) {
	Persona acusador = personaRepository.findByDui(request.getDuiAcusador())
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el acusador"));

	Persona acusado = personaRepository.findByDui(request.getDuiAcusado())
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el acusado"));

	Cargo cargo = Cargo.builder()
		.fecha(request.getFecha())
		.descripcion(request.getDescripcion())
		.acusador(acusador)
		.acusado(acusado)
		.tipoCargo(request.getTipoCargo())
		.build();

	Cargo cargoGuardado = cargoRepository.save(cargo);
	return toCargoResponseDTO(cargoGuardado);
    }

    @Override
    public CargosPersonaResponseDTO obtenerCargosPorDui(String dui) {
	Persona persona = personaRepository.findByDui(dui)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro la persona"));

	List<CargoResponseDTO> cargos = cargoRepository.findByAcusado(persona)
		.stream()
		.map(this::toCargoResponseDTO)
		.toList();

	return CargosPersonaResponseDTO.builder()
		.id(persona.getId())
		.nombre(persona.getNombre())
		.dui(persona.getDui())
		.telefono(persona.getTelefono())
		.cargos(cargos)
		.build();
    }

    private CargoResponseDTO toCargoResponseDTO(Cargo cargo) {
	return CargoResponseDTO.builder()
		.id(cargo.getId())
		.fecha(cargo.getFecha())
		.descripcion(cargo.getDescripcion())
		.tipoCargo(cargo.getTipoCargo())
		.tipoCargoTexto(String.valueOf(cargo.getTipoCargo()))
		.nombreAcusador(cargo.getAcusador().getNombre())
		.duiAcusador(cargo.getAcusador().getDui())
		.nombreAcusado(cargo.getAcusado().getNombre())
		.duiAcusado(cargo.getAcusado().getDui())
		.build();
    }
}
