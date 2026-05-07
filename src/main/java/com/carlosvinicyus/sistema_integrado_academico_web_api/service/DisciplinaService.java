package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Disciplina;

import java.util.List;

public interface DisciplinaService {
    Disciplina buscarPorId(Long id);
    List<Disciplina> listarTodos();
    Disciplina salvar(Disciplina disciplina);
}
