package org.example.laboratorio02.Repository;

import org.example.laboratorio02.Model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iDireccionRepository extends JpaRepository<Direccion, Long> {
}
