package org.example.laboratorio02.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="persona")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="nombre",nullable=false,length=100)
    private String nombre;

    @Column(name="dui",nullable=false, unique=true, length=10)
    private String DUI;

    @Column(name="telefono", nullable = false, length=10)
    private String telefono;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_direccion", nullable=false)
    private Direccion direccion;

}
