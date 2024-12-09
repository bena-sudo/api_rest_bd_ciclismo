package edu.alumno.joan.api_rest_bd_ciclismo.srv.impl;

import edu.alumno.joan.api_rest_bd_ciclismo.repository.EquipoRepository;
import edu.alumno.joan.api_rest_bd_ciclismo.srv.EquipoService;
import edu.alumno.joan.api_rest_bd_ciclismo.srv.mapper.CiclistaMapper;
import edu.alumno.joan.api_rest_bd_ciclismo.srv.mapper.EquipoMapper;
import edu.alumno.joan.api_rest_bd_ciclismo.srv.specification.FiltroBusquedaSpecification;

import edu.alumno.joan.api_rest_bd_ciclismo.exception.EquipoNotFoundExcepcion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import edu.alumno.joan.api_rest_bd_ciclismo.model.db.CiclistaDB;
import edu.alumno.joan.api_rest_bd_ciclismo.model.db.EquipoDB;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.CiclistaEditDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.EquipoEditDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.EquipoInfoDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.EquipoListDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.PaginaDTO;

@Service
public class EquipoServiceImpl implements EquipoService {
    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public EquipoInfoDTO getEquipoInfoById(Long id) {
        EquipoDB equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new EquipoNotFoundExcepcion("EQUIPO NOT FOUND", "Equipo no encontrado: " + id));
        return EquipoMapper.INSTANCE.equipoToEquipoInfoDTO(equipo);
    }

    @Override
    public List<EquipoListDTO> findAllEquipoList() {
        return EquipoMapper.INSTANCE.equiposToEquipoListDTOs(equipoRepository.findAll());
    }

    @Override
    public List<EquipoListDTO> findAllEquipoList(Sort sort) {
        return EquipoMapper.INSTANCE.equiposToEquipoListDTOs(equipoRepository.findAll(sort));
    }

    @Override
    public List<EquipoListDTO> findAllEquiposByNombre(String nombre, Sort sort) {
        return EquipoMapper.INSTANCE
                .equiposToEquipoListDTOs(equipoRepository.findByNombreContaining(nombre, sort));
    }

    @Override
    public PaginaDTO<EquipoListDTO> findAllPageEquipoList(Pageable paging) {
        Page<EquipoDB> paginaEquipos = equipoRepository.findAll(paging);
        return new PaginaDTO<EquipoListDTO>(
                paginaEquipos.getNumber(),
                paginaEquipos.getSize(),
                paginaEquipos.getTotalElements(),
                paginaEquipos.getTotalPages(),
                EquipoMapper.INSTANCE.equiposToEquipoListDTOs(paginaEquipos.getContent()),
                paginaEquipos.getSort());
    }

    @Override
    public PaginaDTO<EquipoListDTO> findByNombreContaining(String nombre, Pageable paging) {
        Page<EquipoDB> paginaEquipos = equipoRepository.findByNombreContaining(nombre, paging);
        return new PaginaDTO<EquipoListDTO>(
                paginaEquipos.getNumber(),
                paginaEquipos.getSize(),
                paginaEquipos.getTotalElements(),
                paginaEquipos.getTotalPages(),
                EquipoMapper.INSTANCE.equiposToEquipoListDTOs(paginaEquipos.getContent()),
                paginaEquipos.getSort());
    }

    @Override
    public PaginaDTO<EquipoListDTO> findAll(List<FiltroBusqueda> listaFiltros, Pageable paging) {
        Specification<EquipoDB> filtrosSpecification = new FiltroBusquedaSpecification<>(listaFiltros);
        Page<EquipoDB> paginaEquipos = equipoRepository.findAll(filtrosSpecification, paging);

        return new PaginaDTO<EquipoListDTO>(
                paginaEquipos.getNumber(),
                paginaEquipos.getSize(),
                paginaEquipos.getTotalElements(),
                paginaEquipos.getTotalPages(),
                EquipoMapper.INSTANCE.equiposToEquipoListDTOs(paginaEquipos.getContent()),
                paginaEquipos.getSort());
    }

    @Override
    public EquipoEditDTO createEquipo(EquipoEditDTO equipoEditDTO) {
        return  EquipoMapper.INSTANCE.equipoToEquipoEditDTO(equipoRepository.save(EquipoMapper.INSTANCE.equipoEditToEquipoDB(equipoEditDTO)));
    }

    @Override
    public Optional<EquipoEditDTO> updateEquipo(EquipoEditDTO equipoEditDTO) {
        Optional<EquipoDB> equipoOptional = equipoRepository.findById(equipoEditDTO.getId());
        if (equipoOptional.isPresent()) {
            EquipoDB equipoDB = equipoOptional.get();
            EquipoMapper.INSTANCE.updateEquipoFromEquipoEditDTO(equipoEditDTO, equipoDB);
            return Optional.of(EquipoMapper.INSTANCE.equipoToEquipoEditDTO(equipoRepository.save(equipoDB)));
        }
        return Optional.empty();
    }

    public boolean deleteEquipoById(Long id) {
        if (equipoRepository.existsById(id)) {
            equipoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
