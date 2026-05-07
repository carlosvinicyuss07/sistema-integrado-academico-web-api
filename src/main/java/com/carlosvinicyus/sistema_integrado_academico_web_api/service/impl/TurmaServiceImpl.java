package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Turma;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.TurmaRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.ProfessorService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.TurmaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepository turmaRepository;
    private final ProfessorService professorService;

    @Override
    public Turma buscarPorId(Long id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Turma não encontrada com id: " + id));
    }

    @Override
    public List<Turma> listarTodas() {
        return turmaRepository.findAll();
    }

    @Override
    public List<Turma> listarPorProfessor(Long professorId) {
        professorService.buscarPorId(professorId);
        return turmaRepository.findByProfessorId(professorId);
    }

    @Override
    @Transactional
    public Turma salvar(Turma turma) {
        if (turma.getProfessor() != null && turma.getProfessor().getId() != null) {
            professorService.buscarPorId(turma.getProfessor().getId());
        }

        return turmaRepository.save(turma);
    }
}
