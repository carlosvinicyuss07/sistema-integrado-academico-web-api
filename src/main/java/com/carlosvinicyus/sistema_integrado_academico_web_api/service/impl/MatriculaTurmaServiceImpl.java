package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.MatriculaTurma;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.MatriculaTurmaRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.AlunoService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.MatriculaTurmaService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.TurmaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaTurmaServiceImpl implements MatriculaTurmaService {

    private final MatriculaTurmaRepository matriculaTurmaRepository;
    private final AlunoService alunoService;
    private final TurmaService turmaService;

    @Override
    public MatriculaTurma buscarPorId(Long id) {
        return matriculaTurmaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matrícula não encontrada com id: " + id));
    }

    @Override
    public List<MatriculaTurma> listarPorAluno(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return matriculaTurmaRepository.findByAlunoId(alunoId);
    }

    @Override
    public List<MatriculaTurma> listarPorTurma(Long turmaId) {
        turmaService.buscarPorId(turmaId);
        return matriculaTurmaRepository.findByTurmaId(turmaId);
    }

    @Override
    public Integer contarAlunosAtivos(Long turmaId) {
        turmaService.buscarPorId(turmaId);
        return matriculaTurmaRepository.contarAlunosAtivosNaTurma(turmaId);
    }

    @Override
    @Transactional
    public MatriculaTurma realizarMatricula(MatriculaTurma matriculaTurma) {
        alunoService.buscarPorId(matriculaTurma.getAluno().getId());
        turmaService.buscarPorId(matriculaTurma.getTurma().getId());

        // Regra para evitar matrículas duplicadas
        List<MatriculaTurma> matriculasDoAluno = matriculaTurmaRepository.findByAlunoId(matriculaTurma.getAluno().getId());
        boolean jaMatriculadoNaTurma = matriculasDoAluno.stream()
                .anyMatch(m -> m.getTurma().getId().equals(matriculaTurma.getTurma().getId()));

        if (jaMatriculadoNaTurma) {
            throw new IllegalStateException("Aluno já está matriculado nesta turma.");
        }

        if (matriculaTurma.getSituacao() == null) {
            matriculaTurma.setSituacao("MATRICULADO");
        }

        return matriculaTurmaRepository.save(matriculaTurma);
    }
}
