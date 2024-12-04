package edu.alumno.joan.api_rest_bd_ciclismo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import edu.alumno.joan.api_rest_bd_ciclismo.model.db.CiclistaDB;
import jakarta.annotation.Nonnull;

@Repository
public interface CiclistaRepository extends JpaRepository<CiclistaDB, Long>, JpaSpecificationExecutor<CiclistaDB> {

    @Nonnull
    @SuppressWarnings({ "null", "override" })
    List<CiclistaDB> findAll(@NonNull Sort sort);

    @NonNull
    List<CiclistaDB> findByNombreContaining(@Nonnull String nombre, @Nonnull Sort sort);

    @Nonnull
    @SuppressWarnings({ "override", "null" })
    Page<CiclistaDB> findAll(@NonNull Pageable pageable);

    @NonNull
    Page<CiclistaDB> findByNombreContaining(@Nonnull String nombre, @NonNull Pageable pageable);

    @NonNull
    List<CiclistaDB> findByNacion(@Nonnull String nacion, @Nonnull Sort sort);
}
