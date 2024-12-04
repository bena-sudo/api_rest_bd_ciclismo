package edu.alumno.joan.api_rest_bd_ciclismo.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class CustomErrorResponse {

    private String errorCode;
    private String message;
    private String timestamp;


    public CustomErrorResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
