package com.carlosvinicyus.sistema_integrado_academico_web_api.service.impl;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Disciplina;
import com.carlosvinicyus.sistema_integrado_academico_web_api.repository.DisciplinaRepository;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.DisciplinaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaServiceImpl implements DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    @Override
    public Disciplina buscarPorId(Long id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada com id: " + id));
    }

    @Override
    public List<Disciplina> listarTodos() {
        return disciplinaRepository.findAll();
    }

    @Override
    @Transactional
    public Disciplina salvar(Disciplina disciplina) {

        // Validação da carga horária
        if (disciplina.getCargaHoraria() == null || disciplina.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("A carga horária da disciplina deve ser maior que zero.");
        }

        return disciplinaRepository.save(disciplina);
    }
}
