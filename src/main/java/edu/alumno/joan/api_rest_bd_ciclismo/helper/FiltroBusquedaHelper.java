package edu.alumno.joan.api_rest_bd_ciclismo.helper;

import java.util.ArrayList;
import java.util.List;

import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.FiltroBusqueda;

public class FiltroBusquedaHelper {

    /**
     * Convierte un array de cadenas en una lista de FiltroBusqueda.
     * Detecta el operador (>, <, :) automáticamente y maneja valores que contienen el operador.
     *
     * @param filtros Array de cadenas en formato "atributo>valor", "atributo<valor", "atributo:valor".
     * @return Lista de FiltroBusqueda.
     */
    public static List<FiltroBusqueda> createFiltroBusqueda(String[] filtros) {
        List<FiltroBusqueda> listaFiltros = new ArrayList<>();

        if (filtros == null || filtros.length == 0) {
            return listaFiltros; // Devuelve una lista vacía si no hay filtros
        }

        for (String filtro : filtros) { // Detectar el operador basado en el orden de prioridad
            int posOperador = -1;
            String operador = null;

            if ((posOperador = filtro.indexOf(">")) != -1) {
                operador = ">";
            } else if ((posOperador = filtro.indexOf("<")) != -1) {
                operador = "<";
            } else if ((posOperador = filtro.indexOf(":")) != -1) {
                operador = ":";
            }

            if (operador == null) {
                throw new IllegalArgumentException("El filtro no contiene un operador válido: " + filtro);
            }

            // Extraer el atributo (todo antes del operador) y el valor (todo después del operador)
            String atributo = filtro.substring(0, posOperador).trim();
            String valor = filtro.substring(posOperador + 1).trim();
            if (atributo.isEmpty() || valor.isEmpty()) {
                throw new IllegalArgumentException("El filtro debe tener un atributo y un valor: " + filtro);
            }

            // Crear un nuevo FiltroBusqueda y añadirlo a la lista
            listaFiltros.add(new FiltroBusqueda(atributo, operador, valor));
        }

        return listaFiltros;
    }
}

