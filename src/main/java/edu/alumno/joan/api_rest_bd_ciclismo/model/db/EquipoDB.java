package edu.alumno.joan.api_rest_bd_ciclismo.model.db;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@Table(name = "Equipo")
public class EquipoDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombree", nullable = false)
    private String nombre;

    @Column(name = "nacion", nullable = false)
    private String nacion;

    @Column(name = "direct", nullable = false)
    private String director;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<PerteneceDB> ciclistas;

}
