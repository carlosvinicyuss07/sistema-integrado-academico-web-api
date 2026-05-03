package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Turma;

import java.util.List;

public interface TurmaService {
    Turma buscarPorId(Long id);
    List<Turma> listarTodas();
    List<Turma> listarPorProfessor(Long professorId);
    Turma salvar(Turma turma);
}
