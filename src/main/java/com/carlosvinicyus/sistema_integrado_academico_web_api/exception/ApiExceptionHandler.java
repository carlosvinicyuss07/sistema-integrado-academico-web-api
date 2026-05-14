package com.carlosvinicyus.sistema_integrado_academico_web_api.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
        var details = ex.getBindingResult().getFieldErrors().stream()
            .map(err -> new ApiError.FieldError(err.getField(), err.getDefaultMessage()))
            .toList();
        return ResponseEntity.badRequest().body(ApiError.validation(details));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiError.of("NOT_FOUND", ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleConflict(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiError.of("CONFLICT", ex.getMessage()));
    }
}
