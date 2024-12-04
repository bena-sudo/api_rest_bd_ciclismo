package edu.alumno.joan.api_rest_bd_ciclismo.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public ResourceNotFoundException(String message) {
        super(message);
    }
}
