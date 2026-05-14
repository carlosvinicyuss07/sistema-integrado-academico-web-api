package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Falta;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.FaltaRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.FaltaService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.MatriculaTurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaltaServiceImpl implements FaltaService {

    private final FaltaRepository faltaRepository;
    private final MatriculaTurmaService matriculaTurmaService;

    @Override
    public List<Falta> listarPorMatricula(Long matriculaId) {
        matriculaTurmaService.buscarPorId(matriculaId);
        return faltaRepository.findByMatriculaTurmaId(matriculaId);
    }

    @Override
    @Transactional
    public Falta registrarFalta(Falta falta) {
        matriculaTurmaService.buscarPorId(falta.getMatriculaTurma().getId());

        if (falta.getDataAula() == null) {
            throw new IllegalArgumentException("A data da falta é obrigatória.");
        }

        if (falta.getQuantidade() == null || falta.getQuantidade() <= 0) {
            throw new IllegalArgumentException("A quantidade de faltas deve ser maior que zero.");
        }

        return faltaRepository.save(falta);
    }
}
