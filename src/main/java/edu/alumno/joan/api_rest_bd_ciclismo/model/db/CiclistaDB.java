package edu.alumno.joan.api_rest_bd_ciclismo.model.db;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Ciclista")
public class CiclistaDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombrec", nullable = false)
    private String nombre;

    @Column(name = "nacion", nullable = false)
    private String nacion;

    @Column(name = "fnac", nullable = false)
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private EquipoDB equipo;

    @OneToMany(mappedBy = "ciclista", cascade = CascadeType.ALL)
    private List<GanaDB> pruebasGanadas;

    @OneToMany(mappedBy = "ciclista", cascade = CascadeType.ALL)
    private List<ParticipaDB> participaciones;

}
