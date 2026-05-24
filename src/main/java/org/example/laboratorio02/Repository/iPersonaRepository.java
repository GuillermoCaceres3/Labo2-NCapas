package org.example.laboratorio02.Repository;


import org.example.laboratorio02.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface iPersonaRepository extends JpaRepository<Persona, UUID> {

    Optional<Persona> findByDui(String dui);
    boolean existsByDui(String dui);

}
