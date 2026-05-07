package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Curso;

import java.util.List;

public interface CursoService {
    Curso buscarPorId(Long id);
    List<Curso> listarTodos();
    Curso salvar(Curso curso);
}
