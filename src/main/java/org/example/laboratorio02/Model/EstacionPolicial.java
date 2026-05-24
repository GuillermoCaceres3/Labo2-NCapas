package org.example.laboratorio02.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="estacion_policial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstacionPolicial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="estacion_policial_id")
    private Long id;

    @Column(name="nombre_estacion",nullable = false, length = 100)
    private String nombre;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_direccion", nullable = false)
    private Direccion direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="director_id", nullable = false)
    private Persona director;
}
