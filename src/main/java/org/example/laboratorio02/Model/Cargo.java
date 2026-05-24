package org.example.laboratorio02.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cargos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_acusador", nullable = false)
    private Persona acusador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_acusado", nullable = false)
    private Persona acusado;

    @Column(name = "tipo_cargo", nullable = false)
    private Integer tipoCargo;
}