package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Aluno;

import java.util.List;

public interface AlunoService {
    Aluno buscarPorId(Long id);
    Aluno buscarPorUsuarioId(Long usuarioId);
    List<Aluno> listarTodos();
    Aluno salvar(Aluno aluno);
}
