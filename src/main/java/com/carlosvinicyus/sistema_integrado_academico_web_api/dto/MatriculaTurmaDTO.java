package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record MatriculaTurmaDTO(
        Long id,

        @NotNull(message = "O aluno é obrigatório") Long alunoId,
        String alunoNome,
        String alunoMatricula,

        @NotNull(message = "A turma é obrigatória") Long turmaId,
        String turmaDescricao,

        @Size(max = 50, message = "A situação deve conter no máximo 50 caracteres") String situacao,

        LocalDate dataMatricula) {
}
