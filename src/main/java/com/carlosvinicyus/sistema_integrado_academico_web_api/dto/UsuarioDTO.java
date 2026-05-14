package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioDTO(
    Long id,

    @NotBlank(message = "O nome é obrigatório")
    String nome,

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    String email,

    @NotBlank(message = "O SUAP ID é obrigatório")
    String suapId,

    @NotBlank(message = "O perfil é obrigatório")
    @Pattern(regexp = "^(ALUNO|PROFESSOR|ADMIN)$", message = "O perfil deve ser ALUNO, PROFESSOR ou ADMIN")
    String perfil
) {}
