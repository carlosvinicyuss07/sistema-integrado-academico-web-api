package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.PeriodoLetivoDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.PeriodoLetivoMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.PeriodoLetivo;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.PeriodoLetivoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periodos-letivos")
@RequiredArgsConstructor
public class PeriodoLetivoController {

    private final PeriodoLetivoService periodoLetivoService;
    private final PeriodoLetivoMapper periodoLetivoMapper;

    @GetMapping
    public ResponseEntity<List<PeriodoLetivoDTO>> listarTodos() {
        List<PeriodoLetivoDTO> periodos = periodoLetivoService.listarTodos().stream()
                .map(periodoLetivoMapper::toDTO)
                .toList();
        return ResponseEntity.ok(periodos);
    }

    @PostMapping
    public ResponseEntity<PeriodoLetivoDTO> salvar(@Valid @RequestBody PeriodoLetivoDTO periodoLetivoDTO) {
        PeriodoLetivo periodoLetivo = periodoLetivoMapper.toEntity(periodoLetivoDTO);
        PeriodoLetivo periodoSalvo = periodoLetivoService.salvar(periodoLetivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(periodoLetivoMapper.toDTO(periodoSalvo));
    }
}
