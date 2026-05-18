package com.carlosvinicyus.sistema_integrado_academico_web_api.controller;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.MensagemRequestDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.MensagemResponseDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.mapper.MensagemMapper;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatMensagem;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatTurma;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Usuario;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.ChatTurmaService;
import com.carlosvinicyus.sistema_integrado_academico_web_api.service.MensagemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas/{turmaId}/mensagens")
@RequiredArgsConstructor
public class ChatTurmaController {

    private final MensagemService mensagemService;
    private final ChatTurmaService chatTurmaService;
    private final MensagemMapper mensagemMapper;

    @GetMapping
    public ResponseEntity<List<MensagemResponseDTO>> listarMensagens(
            @PathVariable Long turmaId) {
        
        ChatTurma chatTurma = chatTurmaService.buscarPorTurmaId(turmaId);
        
        List<MensagemResponseDTO> mensagens = mensagemService.obterHistoricoDoChat(chatTurma.getId()).stream()
                .map(mensagemMapper::toDTO)
                .toList();
                
        return ResponseEntity.ok(mensagens);
    }

    @PostMapping
    public ResponseEntity<MensagemResponseDTO> enviarMensagem(
            @PathVariable Long turmaId,
            @RequestHeader("X-Usuario-Id") Long usuarioId,
            @Valid @RequestBody MensagemRequestDTO mensagemRequestDTO) {
        
        ChatTurma chatTurma = chatTurmaService.buscarPorTurmaId(turmaId);
        
        ChatMensagem mensagem = mensagemMapper.toEntity(mensagemRequestDTO);
        
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        mensagem.setUsuario(usuario);
        
        mensagem.setChatTurma(chatTurma);
        
        ChatMensagem mensagemSalva = mensagemService.enviarMensagem(mensagem);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagemMapper.toDTO(mensagemSalva));
    }
}
