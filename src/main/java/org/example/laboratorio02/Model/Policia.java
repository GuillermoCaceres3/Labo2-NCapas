package org.example.laboratorio02.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="policia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Policia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="policia_id")
    private Long id;

    @Column(name="codigo", nullable=false, unique = true, length=20)
    private String codigo;


    @Column(name = "placa", nullable = false, unique = true, length = 20)
    private String placa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estacion_policial", nullable = false)
    private EstacionPolicial estacionPolicial;
}
