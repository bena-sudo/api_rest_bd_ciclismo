package edu.alumno.joan.api_rest_bd_ciclismo.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Prueba")
public class PruebaDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombrep", nullable = false)
    private String nombre;

    @Column(name = "año", nullable = false)
    private int anio;

    @Column(name = "etapas", nullable = false)
    private int etapas;

    @Column(name = "km", nullable = false)
    private double kilometros;

    @OneToMany(mappedBy = "prueba", cascade = CascadeType.ALL)
    private List<GanaDb> ganadores;

    @OneToMany(mappedBy = "prueba", cascade = CascadeType.ALL)
    private List<ParticipaDb> participantes;

}
