package org.example.laboratorio02.Repository;

import org.example.laboratorio02.Model.Cargo;
import org.example.laboratorio02.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iCargoRepository extends JpaRepository<Cargo, Long> {

    List<Cargo> findByAcusado(Persona acusado);
    List<Cargo> findByAcusador(Persona acusador);
}
