package edu.alumno.joan.api_rest_bd_ciclismo.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoListDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
}
