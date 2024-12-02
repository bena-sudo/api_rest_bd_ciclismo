package edu.alumno.joan.api_rest_bd_ciclismo.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Ciclista")
public class CiclistaDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombrec", nullable = false)
    private String nombre;

    @Column(name = "nacion", nullable = false)
    private String nacion;

    @Column(name = "fnac", nullable = false)
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "ciclista", cascade = CascadeType.ALL)
    private List<PerteneceDb> equipos;

    @OneToMany(mappedBy = "ciclista", cascade = CascadeType.ALL)
    private List<GanaDb> pruebasGanadas;

    @OneToMany(mappedBy = "ciclista", cascade = CascadeType.ALL)
    private List<ParticipaDb> participaciones;

}
