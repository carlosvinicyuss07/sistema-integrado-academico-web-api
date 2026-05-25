package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.MatriculaTurma;

import java.util.List;

public interface MatriculaTurmaService {
    MatriculaTurma buscarPorId(Long id);
    List<MatriculaTurma> listarPorAluno(Long alunoId);
    List<MatriculaTurma> listarPorTurma(Long turmaId);
    Integer contarAlunosAtivos(Long turmaId);
    MatriculaTurma realizarMatricula(MatriculaTurma matriculaTurma);
}
