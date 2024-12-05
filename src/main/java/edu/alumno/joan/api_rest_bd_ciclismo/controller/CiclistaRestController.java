package edu.alumno.joan.api_rest_bd_ciclismo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.joan.api_rest_bd_ciclismo.helper.FiltroBusquedaHelper;
import edu.alumno.joan.api_rest_bd_ciclismo.helper.PaginationHelper;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.CiclistaInfoDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.CiclistaListDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.ListadoRespuestaDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.PaginaDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.srv.CiclistaService;

@RestController
@RequestMapping("/api/v1/")
public class CiclistaRestController {

    private final CiclistaService ciclistaService;

    public CiclistaRestController(CiclistaService ciclistaService) {
        this.ciclistaService = ciclistaService;
    }

    @GetMapping("/ciclistas")
    public ResponseEntity<ListadoRespuestaDTO<CiclistaListDTO>> getAllCiclistas(
            @RequestParam(required = false) String[] filter,
            @RequestParam(required = false) String nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        List<FiltroBusqueda> listaFiltros = FiltroBusquedaHelper.createFiltroBusqueda(filter);

        Pageable pageable = PaginationHelper.createPageable(page, size, sort);

        PaginaDTO<CiclistaListDTO> paginaCiclistas = ciclistaService.findAll(listaFiltros, pageable);

        ListadoRespuestaDTO<CiclistaListDTO> response = new ListadoRespuestaDTO<>(
                paginaCiclistas.getNumber(),
                paginaCiclistas.getSize(),
                paginaCiclistas.getTotalElements(),
                paginaCiclistas.getTotalPages(),
                paginaCiclistas.getContent());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ciclistas/orden/{direccionOrden}")
    public Collection<CiclistaListDTO> getCiclistasOrderByName(
            @PathVariable("direccionOrden") String direccionOrden) {
        return ciclistaService.findAllCiclistaList(Sort.by(Direction.fromString(direccionOrden), "nombre"));
    }

    @GetMapping("/ciclistas/{id}/info")
    public ResponseEntity<CiclistaInfoDTO> getCiclistaInfoById(
            @PathVariable(value = "id") Long id) {
        CiclistaInfoDTO ciclistaInfo = ciclistaService.getCiclistaInfoById(id);
        return ResponseEntity.ok().body(ciclistaInfo);
    }

    @GetMapping("/ciclistas/nombre/{nombre}/orden/{direccionOrden}")
    public Collection<CiclistaListDTO> getCiclistasByNameOrder(
            @PathVariable("nombre") String nombre,
            @PathVariable("direccionOrden") String direccionOrden) {
        return ciclistaService.findAllCiclistasByNombre(nombre, Sort.by(Direction.fromString(direccionOrden), "nombre"));
    }

    @DeleteMapping("/ciclistas/{id}")
    public ResponseEntity<String> deleteCiclistaById(@PathVariable("id") Long id) {
        boolean isDeleted = ciclistaService.deleteCiclistaById(id);
        
        if (isDeleted) {
            return ResponseEntity.ok("Ciclista eliminado correctamente");
        } else {
            return ResponseEntity.status(404).body("Ciclista no encontrado");
        }
    }
}
