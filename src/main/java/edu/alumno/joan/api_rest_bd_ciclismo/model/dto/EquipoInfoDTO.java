package edu.alumno.joan.api_rest_bd_ciclismo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String nacion;
    private String director;

    // Relación con ciclistas
    private List<CiclistaListDTO> ciclistas;
}
