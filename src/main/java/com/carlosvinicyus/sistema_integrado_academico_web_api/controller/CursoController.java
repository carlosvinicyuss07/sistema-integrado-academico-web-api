package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.CursoDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Curso;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.CursoMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;
    private final CursoMapper cursoMapper;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarTodos() {
        List<CursoDTO> cursos = cursoService.listarTodos().stream()
                .map(cursoMapper::toDTO)
                .toList();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> buscarPorId(@PathVariable Long id) {
        Curso curso = cursoService.buscarPorId(id);
        return ResponseEntity.ok(cursoMapper.toDTO(curso));
    }

    @PostMapping
    public ResponseEntity<CursoDTO> salvar(@Valid @RequestBody CursoDTO cursoDTO) {
        Curso curso = cursoMapper.toEntity(cursoDTO);
        Curso cursoSalvo = cursoService.salvar(curso);

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoMapper.toDTO(cursoSalvo));
    }
}