package edu.alumno.joan.api_rest_bd_ciclismo.model.db;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Pertenece")
public class PerteneceDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inicio", nullable = false)
    private LocalDate inicio;

    @Column(name = "fin")
    private LocalDate fin;

    @ManyToOne
    @JoinColumn(name = "ciclista_id", nullable = false)
    private CiclistaDb ciclista;

    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    private EquipoDb equipo;

    // Getters y setters
}
