package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CursoDTO(
    Long id,

    @NotBlank(message = "O nome do curso é obrigatório")
    @Size(max = 150, message = "O nome do curso deve conter no máximo 150 caracteres")
    String nome,

    @NotBlank(message = "O código SUAP é obrigatório")
    @Size(max = 100, message = "O código SUAP deve conter no máximo 100 caracteres")
    String codigoSuap
) {}
