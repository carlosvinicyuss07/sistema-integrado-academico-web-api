package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.PeriodoLetivo;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.PeriodoLetivoRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.PeriodoLetivoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeriodoLetivoServiceImpl implements PeriodoLetivoService {

    private final PeriodoLetivoRepository periodoLetivoRepository;

    @Override
    public PeriodoLetivo buscarPorId(Long id) {
        return periodoLetivoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Período letivo não encontrado com id: " + id));
    }

    @Override
    public List<PeriodoLetivo> listarTodos() {
        return periodoLetivoRepository.findAll();
    }

    @Override
    @Transactional
    public PeriodoLetivo salvar(PeriodoLetivo periodoLetivo) {
        return periodoLetivoRepository.save(periodoLetivo);
    }
}
