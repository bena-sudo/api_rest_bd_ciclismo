package edu.alumno.joan.api_rest_bd_ciclismo.srv.impl;

import edu.alumno.joan.api_rest_bd_ciclismo.repository.CiclistaRepository;
import edu.alumno.joan.api_rest_bd_ciclismo.srv.CiclistaService;
import edu.alumno.joan.api_rest_bd_ciclismo.srv.mapper.CiclistaMapper;
import edu.alumno.joan.api_rest_bd_ciclismo.srv.specification.FiltroBusquedaSpecification;

import edu.alumno.joan.api_rest_bd_ciclismo.exception.CiclistaNotFoundExcepcion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import edu.alumno.joan.api_rest_bd_ciclismo.model.db.CiclistaDB;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.CiclistaInfoDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.CiclistaListDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.PaginaDTO;

@Service
public class CiclistaServiceImpl implements CiclistaService {
    private final CiclistaRepository ciclistaRepository;

    public CiclistaServiceImpl(CiclistaRepository ciclistaRepository) {
        this.ciclistaRepository = ciclistaRepository;
    }

    @Override
    public CiclistaInfoDTO getCiclistaInfoById(Long id) {
        CiclistaDB ciclista = ciclistaRepository.findById(id)
                .orElseThrow(() -> new CiclistaNotFoundExcepcion("CIUDAD NOT FOUND", "Ciclista no encontrado: " + id));
        return CiclistaMapper.INSTANCE.ciclistaToCiclistaInfoDTO(ciclista);
    }

    @Override
    public List<CiclistaListDTO> findAllCiclistaList() {
        return CiclistaMapper.INSTANCE.ciclistasToCiclistaListDTOs(ciclistaRepository.findAll());
    }

    @Override
    public List<CiclistaListDTO> findAllCiclistaList(Sort sort) {
        return CiclistaMapper.INSTANCE.ciclistasToCiclistaListDTOs(ciclistaRepository.findAll(sort));
    }

    @Override
    public List<CiclistaListDTO> findAllCiclistasByNombre(String nombre, Sort sort) {
        return CiclistaMapper.INSTANCE
                .ciclistasToCiclistaListDTOs(ciclistaRepository.findByNombreContaining(nombre, sort));
    }

    @Override
    public PaginaDTO<CiclistaListDTO> findAllPageCiclistaList(Pageable paging) {
        Page<CiclistaDB> paginaCiclistas = ciclistaRepository.findAll(paging);
        return new PaginaDTO<CiclistaListDTO>(
                paginaCiclistas.getNumber(),
                paginaCiclistas.getSize(),
                paginaCiclistas.getTotalElements(),
                paginaCiclistas.getTotalPages(),
                CiclistaMapper.INSTANCE.ciclistasToCiclistaListDTOs(paginaCiclistas.getContent()),
                paginaCiclistas.getSort());
    }

    @Override
    public PaginaDTO<CiclistaListDTO> findByNombreContaining(String nombre, Pageable paging) {
        Page<CiclistaDB> paginaCiclistas = ciclistaRepository.findByNombreContaining(nombre, paging);
        return new PaginaDTO<CiclistaListDTO>(
                paginaCiclistas.getNumber(),
                paginaCiclistas.getSize(),
                paginaCiclistas.getTotalElements(),
                paginaCiclistas.getTotalPages(),
                CiclistaMapper.INSTANCE.ciclistasToCiclistaListDTOs(paginaCiclistas.getContent()),
                paginaCiclistas.getSort());
    }

    @Override
    public PaginaDTO<CiclistaListDTO> findAll(List<FiltroBusqueda> listaFiltros, Pageable paging) {
        Specification<CiclistaDB> filtrosSpecification = new FiltroBusquedaSpecification<>(listaFiltros);
        Page<CiclistaDB> paginaCiclistas = ciclistaRepository.findAll(filtrosSpecification, paging);

        return new PaginaDTO<CiclistaListDTO>(
                paginaCiclistas.getNumber(),
                paginaCiclistas.getSize(),
                paginaCiclistas.getTotalElements(),
                paginaCiclistas.getTotalPages(),
                CiclistaMapper.INSTANCE.ciclistasToCiclistaListDTOs(paginaCiclistas.getContent()),
                paginaCiclistas.getSort());
    }
}