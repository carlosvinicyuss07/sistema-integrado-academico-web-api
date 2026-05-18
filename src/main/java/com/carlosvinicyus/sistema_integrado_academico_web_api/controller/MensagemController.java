package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.MensagemResponseDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.MensagemStatusRequestDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.MensagemMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatMensagem;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.MensagemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mensagens")
@RequiredArgsConstructor
public class MensagemController {

    private final MensagemService mensagemService;
    private final MensagemMapper mensagemMapper;

    @PatchMapping("/{id}/status")
    public ResponseEntity<MensagemResponseDTO> atualizarStatus(
            @PathVariable Long id,
            @Valid @RequestBody MensagemStatusRequestDTO statusRequestDTO) {
        
        ChatMensagem mensagemAtualizada = mensagemService.atualizarStatus(id, statusRequestDTO.status());
        return ResponseEntity.ok(mensagemMapper.toDTO(mensagemAtualizada));
    }
}
