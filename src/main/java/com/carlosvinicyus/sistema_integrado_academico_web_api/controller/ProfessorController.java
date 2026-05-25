package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.ProfessorDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.ProfessorMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Professor;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> listarTodos() {
        List<ProfessorDTO> professores = professorService.listarTodos().stream()
                .map(professorMapper::toDTO)
                .toList();
        return ResponseEntity.ok(professores);
    }

    @PostMapping
    public ResponseEntity<ProfessorDTO> salvar(@Valid @RequestBody ProfessorDTO professorDTO) {
        Professor professor = professorMapper.toEntity(professorDTO);
        Professor professorSalvo = professorService.salvar(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorMapper.toDTO(professorSalvo));
    }
}
