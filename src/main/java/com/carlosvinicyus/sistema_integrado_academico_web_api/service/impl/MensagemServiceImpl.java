package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatMensagem;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.MensagemRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.MensagemService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MensagemServiceImpl implements MensagemService {

    private final MensagemRepository mensagemRepository;
    private final UsuarioService usuarioService;

    @Override
    public List<ChatMensagem> obterHistoricoDoChat(Long chatTurmaId) {
        return mensagemRepository.obterHistoricoDoChat(chatTurmaId, 'A');
    }

    @Override
    @Transactional
    public ChatMensagem enviarMensagem(ChatMensagem mensagem) {
        usuarioService.buscarPorId(mensagem.getUsuario().getId());

        if (mensagem.getConteudo() == null || mensagem.getConteudo().trim().isEmpty()) {
            throw new IllegalArgumentException("A mensagem não pode estar vazia.");
        }

        mensagem.setDataEnvio(LocalDateTime.now());

        if (mensagem.getStatus() == null) {
            mensagem.setStatus('A');
        }

        return mensagemRepository.save(mensagem);
    }
}
