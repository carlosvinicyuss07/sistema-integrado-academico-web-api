package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Aluno;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.AlunoRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.AlunoService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;
    private final UsuarioService usuarioService;

    @Override
    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com id: " + id));
    }

    @Override
    public Aluno buscarPorUsuarioId(Long usuarioId) {
        return alunoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    @Override
    @Transactional
    public Aluno salvar(Aluno aluno) {
        // Verificar se o usuário existe antes de salvar o aluno
        if (aluno.getUsuario() != null && aluno.getUsuario().getId() != null) {
            usuarioService.buscarPorId(aluno.getUsuario().getId());
        }

        return alunoRepository.save(aluno);
    }
}
