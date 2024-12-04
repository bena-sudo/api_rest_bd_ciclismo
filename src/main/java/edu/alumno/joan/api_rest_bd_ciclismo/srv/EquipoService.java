package edu.alumno.joan.api_rest_bd_ciclismo.srv;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;

import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.EquipoInfoDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.EquipoListDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.PaginaDTO;

public interface EquipoService {
    EquipoInfoDTO getEquipoInfoById(@NonNull Long id);

    List<EquipoListDTO> findAllEquipoList();

    List<EquipoListDTO> findAllEquipoList(@NonNull Sort sort);

    List<EquipoListDTO> findAllEquiposByNombre(@NonNull String nombre, @NonNull Sort sort);

    PaginaDTO<EquipoListDTO> findAllPageEquipoList(Pageable paging);

    PaginaDTO<EquipoListDTO> findByNombreContaining(String nombre, Pageable paging);

    PaginaDTO<EquipoListDTO> findAll(List<FiltroBusqueda> listaFiltros, Pageable paging);
}
