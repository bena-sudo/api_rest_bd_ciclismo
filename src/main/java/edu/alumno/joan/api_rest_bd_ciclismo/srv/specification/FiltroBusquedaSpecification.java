package edu.alumno.joan.api_rest_bd_ciclismo.srv.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import jakarta.persistence.criteria.Predicate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.FiltroBusqueda;

public class FiltroBusquedaSpecification<T> implements Specification<T> {

    private static final long serialVersionUID = 1L;

    private List<FiltroBusqueda> filtrosBusqueda;

    public FiltroBusquedaSpecification(List<FiltroBusqueda> filtrosBusqueda) {
        this.filtrosBusqueda = filtrosBusqueda;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Predicate toPredicate(
            @NonNull Root<T> root,
            @Nullable CriteriaQuery<?> query,
            @NonNull CriteriaBuilder criteriaBuilder) {

        // Inicializa un predicado compuesto con una conjunción (AND)
        Predicate combinedPredicate = criteriaBuilder.conjunction();

        // Itera sobre los filtros para construir los predicados dinámicamente
        for (FiltroBusqueda filtro : this.filtrosBusqueda) {
            if (filtro.getAtributo() != null && filtro.getValor() != null) {
                switch (filtro.getOperacion()) {
                    case ":":
                        // Utilizamos el símbolo ":" para hacer el LIKE
                        combinedPredicate = criteriaBuilder.and(
                                combinedPredicate,
                                criteriaBuilder.like(
                                        root.get(filtro.getAtributo()),
                                        "%" + filtro.getValor() + "%"));
                        break;
                    case ">":
                        // Utilizamos el símbolo ">" para hacer el MAYOR QUE
                        combinedPredicate = criteriaBuilder.and(
                                combinedPredicate,
                                criteriaBuilder.greaterThan(
                                        root.get(filtro.getAtributo()),
                                        (Comparable) filtro.getValor()));
                        break;
                    case "<":
                        // Utilizamos el símbolo "<" para hacer el MENOR QUE
                        combinedPredicate = criteriaBuilder.and(
                                combinedPredicate,
                                criteriaBuilder.lessThan(
                                        root.get(filtro.getAtributo()),
                                        (Comparable) filtro.getValor()));
                        break;
                    default:
                        throw new UnsupportedOperationException(
                                "Operación de búsqueda no soportada: " + filtro.getOperacion());
                }
            }
        }

        return combinedPredicate;
    }
}
