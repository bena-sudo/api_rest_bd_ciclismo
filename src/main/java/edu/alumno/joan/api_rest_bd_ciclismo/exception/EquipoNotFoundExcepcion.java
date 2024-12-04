package edu.alumno.joan.api_rest_bd_ciclismo.exception;

public class EquipoNotFoundExcepcion extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String errorCode;

    public EquipoNotFoundExcepcion(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
