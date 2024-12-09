package edu.alumno.joan.api_rest_bd_ciclismo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CiclistaInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String nacion;
    private LocalDate fechaNacimiento;

    private List<PerteneceDTO> equipos;
    private List<ParticipaDTO> pruebas;
}
