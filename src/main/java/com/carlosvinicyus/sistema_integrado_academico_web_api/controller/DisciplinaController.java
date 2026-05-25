package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.DisciplinaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.DisciplinaMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Disciplina;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.DisciplinaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;
    private final DisciplinaMapper disciplinaMapper;

    @GetMapping
    public ResponseEntity<List<DisciplinaDTO>> listarTodos() {
        List<DisciplinaDTO> disciplinas = disciplinaService.listarTodos().stream()
                .map(disciplinaMapper::toDto)
                .toList();
        return ResponseEntity.ok(disciplinas);
    }

    @PostMapping
    public ResponseEntity<DisciplinaDTO> salvar(@Valid @RequestBody DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = disciplinaMapper.toEntity(disciplinaDTO);
        Disciplina disciplinaSalva = disciplinaService.salvar(disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaMapper.toDto(disciplinaSalva));
    }
}
