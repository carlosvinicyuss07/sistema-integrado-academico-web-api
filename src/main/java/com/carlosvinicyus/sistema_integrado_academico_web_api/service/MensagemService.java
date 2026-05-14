package com.carlosvinicyus.sistema_integrado_academico_web_api.service;


import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatMensagem;

import java.util.List;

public interface MensagemService {
    List<ChatMensagem> obterHistoricoDoChat(Long chatTurmaId);
    ChatMensagem enviarMensagem(ChatMensagem mensagem);
}
