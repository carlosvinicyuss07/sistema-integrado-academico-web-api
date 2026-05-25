package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Nota;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.NotaRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.MatriculaTurmaService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.NotaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;
    private final MatriculaTurmaService matriculaTurmaService;

    @Override
    public Nota buscarPorId(Long id) {
        return notaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nota não encontrada com id: " + id));
    }

    @Override
    public List<Nota> listarPorMatricula(Long matriculaId) {
        matriculaTurmaService.buscarPorId(matriculaId);
        return notaRepository.findByMatriculaTurmaId(matriculaId);
    }

    @Override
    @Transactional
    public Nota salvar(Nota nota) {
        matriculaTurmaService.buscarPorId(nota.getMatriculaTurma().getId());

        if (nota.getValor().compareTo(BigDecimal.ZERO) < 0 || nota.getValor().compareTo(BigDecimal.valueOf(10)) > 0) {
            throw new IllegalArgumentException("Valor da nota deve ser entre 0 e 10.");
        }

        return notaRepository.save(nota);
    }
}
