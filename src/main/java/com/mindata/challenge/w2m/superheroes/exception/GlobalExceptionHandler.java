package com.mindata.challenge.w2m.superheroes.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        // Loguea la excepción o realiza cualquier acción de gestión de errores aquí
        logger.error("Error inesperado: ", ex.toString());

        // Crea un cuerpo de respuesta con los detalles de la excepción
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Ocurrió un error inesperado.");
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        // Devuelve una respuesta de error con un mensaje apropiado y un código de estado HTTP 500
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
