package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.PeriodoLetivo;

import java.util.List;

public interface PeriodoLetivoService {
    PeriodoLetivo buscarPorId(Long id);
    List<PeriodoLetivo> listarTodos();
    PeriodoLetivo salvar(PeriodoLetivo periodoLetivo);
}
