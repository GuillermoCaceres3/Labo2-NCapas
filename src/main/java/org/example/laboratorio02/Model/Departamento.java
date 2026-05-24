package org.example.laboratorio02.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="departamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departamento {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_departamento")
    private Long id;

    @Column(name= "nombre",nullable = false, unique = true, length = 100)
    private String nombre;

}
