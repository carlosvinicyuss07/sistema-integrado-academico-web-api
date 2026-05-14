package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DisciplinaDTO(
   Long id,

   @NotBlank(message = "O nome da disciplina é obrigatório")
   @Size(min = 3, max = 100, message = "O nome da disciplina deve conter entre 3 e 100 caracteres")
   String nome,

   @NotBlank(message = "O código SUAP da disciplina é obrigatório")
   @Size(max = 20, message = "O código SUAP da disciplina deve conter no máximo 20 caracteres")
   String codigoSuap,

   @NotNull(message = "A carga horária da disciplina é obrigatória")
   @Min(value = 1, message = "A carga horária da disciplina deve ser de pelo menos 1 hora")
   Integer cargaHoraria
) {}
