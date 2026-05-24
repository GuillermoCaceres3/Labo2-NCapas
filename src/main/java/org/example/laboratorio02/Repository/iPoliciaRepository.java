package org.example.laboratorio02.Repository;

import org.example.laboratorio02.Model.Policia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iPoliciaRepository extends JpaRepository<Policia, Long> {

}
