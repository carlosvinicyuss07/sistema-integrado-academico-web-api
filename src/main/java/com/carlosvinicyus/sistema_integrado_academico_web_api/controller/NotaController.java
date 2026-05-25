package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.NotaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.NotaMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.MatriculaTurma;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Nota;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.MatriculaTurmaService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.NotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;
    private final MatriculaTurmaService matriculaTurmaService;
    private final NotaMapper notaMapper;

    @GetMapping("/aluno/{alunoId}/disciplina/{disciplinaId}")
    public ResponseEntity<List<NotaDTO>> listarNotasPorAlunoEDisciplina(
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

        List<NotaDTO> notas = notaService.listarPorMatricula(matriculaDaDisciplina.getId()).stream()
                .map(notaMapper::toDTO)
                .toList();

        return ResponseEntity.ok(notas);
    }

    @GetMapping("/turma/{turmaId}")
    public ResponseEntity<List<NotaDTO>> listarNotasPorTurma(@PathVariable Long turmaId) {
        List<MatriculaTurma> matriculas = matriculaTurmaService.listarPorTurma(turmaId);
        List<NotaDTO> todasNotas = new ArrayList<>();

        for (MatriculaTurma matricula : matriculas) {
            List<NotaDTO> notasDaMatricula = notaService.listarPorMatricula(matricula.getId()).stream()
                    .map(notaMapper::toDTO)
                    .toList();
            todasNotas.addAll(notasDaMatricula);
        }

        return ResponseEntity.ok(todasNotas);
    }

    @PostMapping
    public ResponseEntity<NotaDTO> salvar(@Valid @RequestBody NotaDTO notaDTO) {
        Nota nota = notaMapper.toEntity(notaDTO);
        Nota notaSalva = notaService.salvar(nota);
        return ResponseEntity.status(HttpStatus.CREATED).body(notaMapper.toDTO(notaSalva));
    }
}
