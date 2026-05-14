package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PeriodoLetivoDTO(
    Long id,

    @NotNull(message = "O ano é obrigatório")
    @Min(value = 2000, message = "Ano inválido")
    Integer ano,

    @NotNull(message = "O semestre é obrigatório")
    @Min(value = 1, message = "O semestre deve ser 1 ou 2")
    @Max(value = 2, message = "O semestre deve ser 1 ou 2")
    Integer semestre,

    @NotBlank(message = "A descrição do período letivo é obrigatória")
    @Size(max = 50, message = "A descrição deve conter no máximo 50 caracteres")
    String descricao
) {}
