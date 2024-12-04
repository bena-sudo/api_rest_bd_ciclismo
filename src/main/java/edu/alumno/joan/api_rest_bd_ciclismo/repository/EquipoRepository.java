package edu.alumno.joan.api_rest_bd_ciclismo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import edu.alumno.joan.api_rest_bd_ciclismo.model.db.EquipoDB;
import jakarta.annotation.Nonnull;

@Repository
public interface EquipoRepository extends JpaRepository<EquipoDB, Long>, JpaSpecificationExecutor<EquipoDB> {

    @Nonnull
    @SuppressWarnings({ "null", "override" })
    List<EquipoDB> findAll(@NonNull Sort sort);

    @NonNull
    List<EquipoDB> findByNombreContaining(@Nonnull String nombre, @Nonnull Sort sort);

    @Nonnull
    @SuppressWarnings({ "override", "null" })
    Page<EquipoDB> findAll(@NonNull Pageable pageable);

    @NonNull
    Page<EquipoDB> findByNombreContaining(@Nonnull String nombre, @NonNull Pageable pageable);

    @NonNull
    List<EquipoDB> findByNacion(@Nonnull String nacion, @Nonnull Sort sort);

    @NonNull
    List<EquipoDB> findByDirector(@Nonnull String director, @Nonnull Sort sort);
}
