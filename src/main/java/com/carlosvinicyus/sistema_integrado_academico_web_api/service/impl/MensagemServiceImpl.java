package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Aluno;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatMensagem;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatTurma;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Professor;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Usuario;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.enums.PerfilUsuarioEnum;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.MensagemRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.*;
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
    private final ChatTurmaService chatTurmaService;
    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final MatriculaTurmaService matriculaTurmaService;

    @Override
    public List<ChatMensagem> obterHistoricoDoChat(Long chatTurmaId) {
        return mensagemRepository.obterHistoricoDoChat(chatTurmaId, 'A');
    }

    @Override
    @Transactional
    public ChatMensagem enviarMensagem(ChatMensagem mensagem) {
        Usuario usuario = usuarioService.buscarPorId(mensagem.getUsuario().getId());
        ChatTurma chatTurma = chatTurmaService.buscarPorId(mensagem.getChatTurma().getId());

        if (usuario.getPerfil() == PerfilUsuarioEnum.ALUNO) {
            Aluno aluno = alunoService.buscarPorUsuarioId(usuario.getId());
            boolean matriculado = matriculaTurmaService.listarPorAluno(aluno.getId()).stream()
                    .anyMatch(m -> m.getTurma().getId().equals(chatTurma.getTurma().getId()));
            if (!matriculado) {
                throw new IllegalStateException("O aluno não está matriculado nesta turma e não pode enviar mensagens.");
            }
        } else if (usuario.getPerfil() == PerfilUsuarioEnum.PROFESSOR) {
            Professor professor = professorService.buscarPorUsuarioId(usuario.getId());
            if (chatTurma.getTurma().getProfessor() == null || !chatTurma.getTurma().getProfessor().getId().equals(professor.getId())) {
                throw new IllegalStateException("O professor não leciona nesta turma e não pode enviar mensagens.");
            }
        }

        if (mensagem.getConteudo() == null || mensagem.getConteudo().trim().isEmpty()) {
            throw new IllegalArgumentException("A mensagem não pode estar vazia.");
        }

        mensagem.setDataEnvio(LocalDateTime.now());

        if (mensagem.getStatus() == null) {
            mensagem.setStatus('A');
        }

        return mensagemRepository.save(mensagem);
    }

    @Override
    @Transactional
    public ChatMensagem atualizarStatus(Long id, Character status) {
        ChatMensagem mensagem = mensagemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mensagem não encontrada."));
        
        mensagem.setStatus(status);
        return mensagemRepository.save(mensagem);
    }
}
