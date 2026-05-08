package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProfessorDTO(
    Long id,

    @NotNull(message = "O usuário associado é obrigatório")
    Long usuarioId,
    String usuarioNome,

    @Size(max = 50, message = "A matrícula SIAPE deve conter no máximo 50 caracteres")
    String matriculaSiape,

    @Size(max = 100, message = "O código SUAP deve conter no máximo 100 caracteres")
    String suapId
) {}
