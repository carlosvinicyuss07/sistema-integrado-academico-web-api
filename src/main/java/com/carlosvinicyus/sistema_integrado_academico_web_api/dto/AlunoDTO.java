package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AlunoDTO(
    Long id,

    @NotNull(message = "O usuário associado é obrigatório")
    Long usuarioId,
    String usuarioNome,

    Long cursoId,
    String cursoNome,

    @NotBlank(message = "A matrícula é obrigatória")
    @Size(max = 50, message = "A matrícula deve conter no máximo 50 caracteres")
    String matricula,

    @NotBlank(message = "O código SUAP é obrigatório")
    @Size(max = 100, message = "O código SUAP deve conter no máximo 100 caracteres")
    String suapId
) {}
