package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.UsuarioDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.UsuarioMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        List<UsuarioDTO> usuarios = usuarioService.listarTodos().stream()
                .map(usuarioMapper::toDTO)
                .toList();
        return ResponseEntity.ok(usuarios);
    }
}
