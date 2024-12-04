package edu.alumno.joan.api_rest_bd_ciclismo.model.dto;

import java.util.List;

import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginaDTO<T> {
    int number;
    int size;
    long totalElements;
    int totalPages;
    List<T> content;
    Sort sort;
}