package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import jakarta.validation.constraints.NotNull;

public record MensagemStatusRequestDTO(
    @NotNull(message = "O status da mensagem é obrigatório")
    Character status
) {}
