package edu.alumno.joan.api_rest_bd_ciclismo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.joan.api_rest_bd_ciclismo.helper.FiltroBusquedaHelper;
import edu.alumno.joan.api_rest_bd_ciclismo.helper.PaginationHelper;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.EquipoInfoDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.EquipoListDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.ListadoRespuestaDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.PaginaDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.srv.EquipoService;

@RestController
@RequestMapping("/api/v1/")
public class EquipoRestController {

    private final EquipoService equipoService;

    public EquipoRestController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping("/equipos")
    public ResponseEntity<ListadoRespuestaDTO<EquipoListDTO>> getAllEquipos(
            @RequestParam(required = false) String[] filter,
            @RequestParam(required = false) String nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        List<FiltroBusqueda> listaFiltros = FiltroBusquedaHelper.createFiltroBusqueda(filter);

        Pageable pageable = PaginationHelper.createPageable(page, size, sort);

        PaginaDTO<EquipoListDTO> paginaEquipos = equipoService.findAll(listaFiltros, pageable);

        ListadoRespuestaDTO<EquipoListDTO> response = new ListadoRespuestaDTO<>(
                paginaEquipos.getNumber(),
                paginaEquipos.getSize(),
                paginaEquipos.getTotalElements(),
                paginaEquipos.getTotalPages(),
                paginaEquipos.getContent());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/equipos/orden/{direccionOrden}")
    public Collection<EquipoListDTO> getEquiposOrderByName(
            @PathVariable("direccionOrden") String direccionOrden) {
        return equipoService.findAllEquipoList(Sort.by(Direction.fromString(direccionOrden), "nombre"));
    }

    @GetMapping("/equipos/{id}/info")
    public ResponseEntity<EquipoInfoDTO> getEquipoInfoById(
            @PathVariable(value = "id") Long id) {
        EquipoInfoDTO equipoInfo = equipoService.getEquipoInfoById(id);
        return ResponseEntity.ok().body(equipoInfo);
    }

    @GetMapping("/equipos/nombre/{nombre}/orden/{direccionOrden}")
    public Collection<EquipoListDTO> getEquiposByNameOrder(
            @PathVariable("nombre") String nombre,
            @PathVariable("direccionOrden") String direccionOrden) {
        return equipoService.findAllEquiposByNombre(nombre, Sort.by(Direction.fromString(direccionOrden), "nombre"));
    }
}
