package edu.alumno.joan.api_rest_bd_ciclismo.exception;

public class CiclistaNotFoundExcepcion extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String errorCode;

    public CiclistaNotFoundExcepcion(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
