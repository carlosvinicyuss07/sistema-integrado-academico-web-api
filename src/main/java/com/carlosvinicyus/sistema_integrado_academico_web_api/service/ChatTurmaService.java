package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatTurma;

public interface ChatTurmaService {
    ChatTurma buscarPorId(Long id);
    ChatTurma buscarPorTurmaId(Long turmaId);
    ChatTurma salvar(ChatTurma chatTurma);
}
