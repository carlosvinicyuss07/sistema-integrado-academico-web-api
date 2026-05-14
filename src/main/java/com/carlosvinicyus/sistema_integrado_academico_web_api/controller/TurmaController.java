package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.TurmaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Turma;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.TurmaMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.TurmaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService turmaService;
    private final TurmaMapper turmaMapper;

    @GetMapping
    public ResponseEntity<List<TurmaDTO>> listarTodas() {
        List<TurmaDTO> turmas = turmaService.listarTodas().stream()
                .map(turmaMapper::toDTO)
                .toList();
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDTO> buscarPorId(@PathVariable Long id) {
        Turma turma = turmaService.buscarPorId(id);
        return ResponseEntity.ok(turmaMapper.toDTO(turma));
    }

    @PostMapping
    public ResponseEntity<TurmaDTO> salvar(@Valid @RequestBody TurmaDTO turmaDTO) {
        Turma turma = turmaMapper.toEntity(turmaDTO);
        Turma turmaSalva = turmaService.salvar(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaMapper.toDTO(turmaSalva));
    }
}
