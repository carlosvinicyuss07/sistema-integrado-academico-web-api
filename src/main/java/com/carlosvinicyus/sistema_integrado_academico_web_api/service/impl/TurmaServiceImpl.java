package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Turma;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.TurmaRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.DisciplinaService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.PeriodoLetivoService;
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
    private final DisciplinaService disciplinaService;
    private final PeriodoLetivoService periodoLetivoService;

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
        } else {
            throw new IllegalArgumentException("A turma deve estar vinculada a um professor obrigatoriamente.");
        }

        if (turma.getDisciplina() != null && turma.getDisciplina().getId() != null) {
            disciplinaService.buscarPorId(turma.getDisciplina().getId());
        } else {
            throw new IllegalArgumentException("A turma deve estar vinculada a uma disciplina obrigatoriamente.");
        }

        if (turma.getPeriodoLetivo() != null && turma.getPeriodoLetivo().getId() != null) {
            periodoLetivoService.buscarPorId(turma.getPeriodoLetivo().getId());
        } else {
            throw new IllegalArgumentException("A turma deve estar vinculada a um período letivo obrigatoriamente.");
        }

        return turmaRepository.save(turma);
    }
}
