package org.example.laboratorio02.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="municipio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_municipio")
    private Long id;

    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_departamento", nullable = false)
    private Departamento departamento;
}
