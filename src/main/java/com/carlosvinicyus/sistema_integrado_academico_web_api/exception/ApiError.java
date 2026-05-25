package com.carlosvinicyus.sistema_integrado_academico_web_api.exception;

import java.util.List;

public record ApiError(String code, String message, List<FieldError> details) {

    public record FieldError(String field, String error) {}

    public static ApiError of(String code, String message) {
        return new ApiError(code, message, List.of());
    }

    public static ApiError validation(List<FieldError> details) {
        return new ApiError("VALIDATION_ERROR", "Falha na validação", details);
    }
}
