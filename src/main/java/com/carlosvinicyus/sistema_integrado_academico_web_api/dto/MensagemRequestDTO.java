package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.NotBlank;

public record MensagemRequestDTO(
    @NotBlank(message = "O conteúdo da mensagem é obrigatório")
    String conteudo
) {}
