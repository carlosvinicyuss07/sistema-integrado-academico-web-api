package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.MatriculaTurmaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.MatriculaTurmaMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.MatriculaTurma;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.MatriculaTurmaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
@RequiredArgsConstructor
public class MatriculaTurmaController {

    private final MatriculaTurmaService matriculaTurmaService;
    private final MatriculaTurmaMapper matriculaTurmaMapper;

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<MatriculaTurmaDTO>> listarPorAluno(@PathVariable Long alunoId) {
        List<MatriculaTurmaDTO> matriculas = matriculaTurmaService.listarPorAluno(alunoId)
                .stream()
                .map(matriculaTurmaMapper::toDto)
                .toList();
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/turma/{turmaId}")
    public ResponseEntity<List<MatriculaTurmaDTO>> listarPorTurma(@PathVariable Long turmaId) {
        List<MatriculaTurmaDTO> matriculas = matriculaTurmaService.listarPorTurma(turmaId)
                .stream()
                .map(matriculaTurmaMapper::toDto)
                .toList();
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/turma/{turmaId}/ocupacao")
    public ResponseEntity<Integer> contarAlunosAtivos(@PathVariable Long turmaId) {
        Integer ocupacao = matriculaTurmaService.contarAlunosAtivos(turmaId);
        return ResponseEntity.ok(ocupacao);
    }

    @PostMapping
    public ResponseEntity<MatriculaTurmaDTO> realizarMatricula(@Valid @RequestBody MatriculaTurmaDTO matriculaDTO) {
        MatriculaTurma matricula = matriculaTurmaMapper.toEntity(matriculaDTO);
        MatriculaTurma matriculaSalva = matriculaTurmaService.realizarMatricula(matricula);
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaTurmaMapper.toDto(matriculaSalva));
    }
}
