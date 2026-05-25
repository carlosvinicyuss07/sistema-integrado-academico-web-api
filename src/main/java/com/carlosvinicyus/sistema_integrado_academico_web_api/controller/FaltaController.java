package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.FaltaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.FaltaMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Falta;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.MatriculaTurma;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.FaltaService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.MatriculaTurmaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/faltas")
@RequiredArgsConstructor
public class FaltaController {

    private final FaltaService faltaService;
    private final MatriculaTurmaService matriculaTurmaService;
    private final FaltaMapper faltaMapper;

    @GetMapping("/aluno/{alunoId}/disciplina/{disciplinaId}")
    public ResponseEntity<List<FaltaDTO>> listarFaltasPorAlunoEDisciplina(
            @PathVariable Long alunoId,
            @PathVariable Long disciplinaId) {

        List<MatriculaTurma> matriculas = matriculaTurmaService.listarPorAluno(alunoId);

        // Encontra a matrícula específica para a disciplina informada
        MatriculaTurma matriculaDaDisciplina = matriculas.stream()
                .filter(m -> m.getTurma().getDisciplina().getId().equals(disciplinaId))
                .findFirst()
                .orElse(null);

        if (matriculaDaDisciplina == null) {
            return ResponseEntity.notFound().build();
        }

        List<FaltaDTO> faltas = faltaService.listarPorMatricula(matriculaDaDisciplina.getId()).stream()
                .map(faltaMapper::toDTO)
                .toList();

        return ResponseEntity.ok(faltas);
    }

    @GetMapping("/turma/{turmaId}")
    public ResponseEntity<List<FaltaDTO>> listarFaltasPorTurma(@PathVariable Long turmaId) {
        List<MatriculaTurma> matriculas = matriculaTurmaService.listarPorTurma(turmaId);
        List<FaltaDTO> todasFaltas = new ArrayList<>();

        for (MatriculaTurma matricula : matriculas) {
            List<FaltaDTO> faltasDaMatricula = faltaService.listarPorMatricula(matricula.getId()).stream()
                    .map(faltaMapper::toDTO)
                    .toList();
            todasFaltas.addAll(faltasDaMatricula);
        }

        return ResponseEntity.ok(todasFaltas);
    }

    @PostMapping
    public ResponseEntity<FaltaDTO> registrarFalta(@Valid @RequestBody FaltaDTO faltaDTO) {
        Falta falta = faltaMapper.toEntity(faltaDTO);
        Falta faltaSalva = faltaService.registrarFalta(falta);
        return ResponseEntity.status(HttpStatus.CREATED).body(faltaMapper.toDTO(faltaSalva));
    }
}
