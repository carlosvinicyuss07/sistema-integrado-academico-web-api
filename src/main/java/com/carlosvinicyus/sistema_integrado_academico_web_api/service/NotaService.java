package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Nota;

import java.util.List;

public interface NotaService {
    Nota buscarPorId(Long id);
    List<Nota> listarPorMatricula(Long matriculaId);
    Nota salvar(Nota nota);
}
