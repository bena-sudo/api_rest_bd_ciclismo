package edu.alumno.joan.api_rest_bd_ciclismo.model.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoEditDTO implements  Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "El nombre del equipo no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La nacionalidad no puede estar vacía")
    private String nacion;

    @NotBlank(message = "El nombre del director no puede estar vacío")
    private String director;
}
