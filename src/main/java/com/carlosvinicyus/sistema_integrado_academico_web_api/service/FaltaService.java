package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Falta;

import java.util.List;

public interface FaltaService {
    List<Falta> listarPorMatricula(Long matriculaId);
    Falta registrarFalta(Falta falta);
}
