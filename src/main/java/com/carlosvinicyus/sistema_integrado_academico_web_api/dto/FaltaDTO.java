package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record FaltaDTO(
    Long id,

    @NotNull(message = "A matrícula da turma é obrigatória")
    Long matriculaTurmaId,

    @NotNull(message = "A data da aula é obrigatória")
    LocalDate dataAula,

    @NotNull(message = "A quantidade de faltas é obrigatória")
    @Min(value = 1, message = "A quantidade de faltas deve ser pelo menos 1")
    Integer quantidade,

    String justificativa,

    @Size(max = 100, message = "O código SUAP deve conter no máximo 100 caracteres")
    String codigoSuap
) {}
