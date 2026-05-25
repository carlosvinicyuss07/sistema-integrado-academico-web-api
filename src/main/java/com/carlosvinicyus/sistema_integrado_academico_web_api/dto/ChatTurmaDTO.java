package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public record ChatTurmaDTO(
    Long id,

    @NotNull(message = "A turma é obrigatória")
    Long turmaId,
    String turmaDescricao,

    @Size(max = 150, message = "O título deve conter no máximo 150 caracteres")
    String titulo,

    LocalDateTime criacao
) {}
