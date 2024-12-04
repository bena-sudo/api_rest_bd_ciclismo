package edu.alumno.joan.api_rest_bd_ciclismo.model.db;

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
@Table(name = "Participa")
public class ParticipaDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "puesto", nullable = false)
    private int puesto;

    @ManyToOne
    @JoinColumn(name = "ciclista_id", nullable = false)
    private CiclistaDB ciclista;

    @ManyToOne
    @JoinColumn(name = "prueba_id", nullable = false)
    private PruebaDb prueba;

    // Getters y setters
}
