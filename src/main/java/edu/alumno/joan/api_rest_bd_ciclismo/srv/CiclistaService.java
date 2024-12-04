package edu.alumno.joan.api_rest_bd_ciclismo.srv;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;

import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.CiclistaInfoDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.CiclistaListDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.PaginaDTO;

public interface CiclistaService {
    CiclistaInfoDTO getCiclistaInfoById(@NonNull Long id);

    List<CiclistaListDTO> findAllCiclistaList();

    List<CiclistaListDTO> findAllCiclistaList(@NonNull Sort sort);

    List<CiclistaListDTO> findAllCiclistasByNombre(@NonNull String nombre, @NonNull Sort sort);

    PaginaDTO<CiclistaListDTO> findAllPageCiclistaList(Pageable paging);

    PaginaDTO<CiclistaListDTO> findByNombreContaining(String nombre, Pageable paging);

    PaginaDTO<CiclistaListDTO> findAll(List<FiltroBusqueda> listaFiltros, Pageable paging);
}
