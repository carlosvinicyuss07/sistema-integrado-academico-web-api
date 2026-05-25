package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.AlunoDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.AlunoMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Aluno;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;
    private final AlunoMapper alunoMapper;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarTodos() {
        List<AlunoDTO> alunos = alunoService.listarTodos().stream()
                .map(alunoMapper::toDTO)
                .toList();
        return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> salvar(@Valid @RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        Aluno alunoSalvo = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoMapper.toDTO(alunoSalvo));
    }
}
