package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Professor;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.ProfessorRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.ProfessorService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final UsuarioService usuarioService;

    @Override
    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com id: " + id));
    }

    @Override
    public Professor buscarPorUsuarioId(Long usuarioId) {
        return professorRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    @Override
    @Transactional
    public Professor salvar(Professor professor) {
        // Verificar se o usuário existe antes de salvar o professor
        if (professor.getUsuario() != null && professor.getUsuario().getId() != null) {
            usuarioService.buscarPorId(professor.getUsuario().getId());
        }

        return professorRepository.save(professor);
    }
}
