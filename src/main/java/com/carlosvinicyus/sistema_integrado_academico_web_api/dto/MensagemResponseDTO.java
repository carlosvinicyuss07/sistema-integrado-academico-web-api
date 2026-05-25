package com.carlosvinicyus.sistema_integrado_academico_web_api.dto;

import java.time.LocalDateTime;

public record MensagemResponseDTO(
    Long id,
    Long chatTurmaId,
    Long usuarioId,
    String remetenteNome,
    String conteudo,
    LocalDateTime dataEnvio
) {}
