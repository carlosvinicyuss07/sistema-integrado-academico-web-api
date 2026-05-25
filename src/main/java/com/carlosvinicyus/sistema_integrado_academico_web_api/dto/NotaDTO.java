package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public record NotaDTO(
    Long id,

    @NotNull(message = "A matrícula da turma é obrigatória")
    Long matriculaTurmaId,

    @NotBlank(message = "A descrição da nota é obrigatória")
    @Size(max = 100, message = "A descrição deve conter no máximo 100 caracteres")
    String descricao,

    @PositiveOrZero(message = "O valor da nota deve ser zero ou positivo")
    BigDecimal valor,

    @PositiveOrZero(message = "O peso da nota deve ser zero ou positivo")
    BigDecimal peso,

    LocalDate dataAvaliacao,

    @NotBlank(message = "O código SUAP é obrigatório")
    @Size(max = 100, message = "O código SUAP deve conter no máximo 100 caracteres")
    String codigoSuap
) {}
