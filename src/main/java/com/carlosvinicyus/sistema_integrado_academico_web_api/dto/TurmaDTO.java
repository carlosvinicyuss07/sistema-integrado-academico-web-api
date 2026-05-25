package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TurmaDTO(
    Long id,

    @NotNull(message = "A disciplina é obrigatória")
    Long disciplinaId,
    String disciplinaNome,

    Long professorId,
    String professorNome,

    @NotNull(message = "O período letivo é obrigatório")
    Long periodoLetivoId,
    String periodoLetivoDescricao,

    @NotBlank(message = "A descrição da turma é obrigatória")
    @Size(max = 150, message = "A descrição deve conter no máximo 150 caracteres")
    String descricao,

    @NotBlank(message = "O código SUAP é obrigatório")
    @Size(max = 100, message = "O código SUAP deve conter no máximo 100 caracteres")
    String codigoSuap
) {}
