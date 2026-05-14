package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Professor;

import java.util.List;

public interface ProfessorService {
    Professor buscarPorId(Long id);
    Professor buscarPorUsuarioId(Long usuarioId);
    List<Professor> listarTodos();
    Professor salvar(Professor professor);
}
