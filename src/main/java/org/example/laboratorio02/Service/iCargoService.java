package org.example.laboratorio02.Service;

import org.example.laboratorio02.Model.DTOs.CargoRequestDTO;
import org.example.laboratorio02.Model.DTOs.CargoResponseDTO;
import org.example.laboratorio02.Model.DTOs.CargosPersonaResponseDTO;

public interface iCargoService {

	CargoResponseDTO registrarCargo(CargoRequestDTO request);

	CargosPersonaResponseDTO obtenerCargosPorDui(String dui);
}
