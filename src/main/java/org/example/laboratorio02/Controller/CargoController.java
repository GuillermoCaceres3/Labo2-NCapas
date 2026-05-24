package org.example.laboratorio02.Controller;

import jakarta.validation.Valid;
import org.example.laboratorio02.Model.DTOs.CargoRequestDTO;
import org.example.laboratorio02.Model.DTOs.CargoResponseDTO;
import org.example.laboratorio02.Model.DTOs.CargosPersonaResponseDTO;
import org.example.laboratorio02.Service.iCargoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	private final iCargoService cargoService;

	public CargoController(iCargoService cargoService) {
		this.cargoService = cargoService;
	}

	@PostMapping
	public ResponseEntity<CargoResponseDTO> registrarCargo(@RequestBody @Valid CargoRequestDTO request) {
		return ResponseEntity.ok(cargoService.registrarCargo(request));
	}

	@GetMapping("/{dui}")
	public ResponseEntity<CargosPersonaResponseDTO> obtenerCargosPorDui(@PathVariable String dui) {
		return ResponseEntity.ok(cargoService.obtenerCargosPorDui(dui));
	}
}
