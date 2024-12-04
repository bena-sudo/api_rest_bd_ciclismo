package edu.alumno.joan.api_rest_bd_ciclismo.model.db;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<GanaDB> ganadores;

    @OneToMany(mappedBy = "prueba", cascade = CascadeType.ALL)
    private List<ParticipaDB> participantes;

}
