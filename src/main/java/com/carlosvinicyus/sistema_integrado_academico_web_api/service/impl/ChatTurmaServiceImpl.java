package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatTurma;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.ChatTurmaRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.ChatTurmaService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.TurmaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatTurmaServiceImpl implements ChatTurmaService {

    private final ChatTurmaRepository chatTurmaRepository;
    private final TurmaService turmaService;

    @Override
    public ChatTurma buscarPorId(Long id) {
        return chatTurmaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Chat não encontrado com ID: " + id));
    }

    @Override
    public ChatTurma buscarPorTurmaId(Long turmaId) {
        turmaService.buscarPorId(turmaId);
        return chatTurmaRepository.findByTurmaId(turmaId)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum chat ativo para a turma ID: " + turmaId));
    }

    @Override
    @Transactional
    public ChatTurma salvar(ChatTurma chatTurma) {
        if (chatTurma.getTurma() == null || chatTurma.getTurma().getId() == null) {
            throw new IllegalArgumentException("A turma associada ao chat deve ser informada.");
        }
        turmaService.buscarPorId(chatTurma.getTurma().getId());

        Optional<ChatTurma> chatExistente = chatTurmaRepository.findByTurmaId(chatTurma.getTurma().getId());

        if (chatExistente.isPresent()) {
            if (chatTurma.getId() == null) {
                throw new IllegalStateException("Já existe um chat ativo para esta turma. Atualize o chat existente ou desative-o antes de criar um novo.");
            }
            if (!chatExistente.get().getId().equals(chatTurma.getId())) {
                throw new IllegalStateException("Inconsistência de dados: O chat informado não corresponde ao chat oficial da turma.");
            }
        }

        return chatTurmaRepository.save(chatTurma);
    }
}
