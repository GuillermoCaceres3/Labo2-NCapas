package org.example.laboratorio02.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="direccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Direccion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_direccion")
    private Long id;

    @Column(name="calle", nullable = false, length = 50)
    private String calle;

    @Column(name="colonia", nullable = false, length = 50)
    private String colonia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_municipio", nullable = false)
    private Municipio municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_departamento", nullable = false)
    private Departamento departamento;


}
