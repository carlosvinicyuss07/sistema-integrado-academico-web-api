package com.carlosvinicyus.sistema_integrado_academico_web_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "chat_mensagem", schema = "academico")
public class ChatMensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_turma_id", nullable = false)
    private ChatTurma chatTurma;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private String conteudo;

    @Column(name = "data_envio", insertable = false, updatable = false)
    private LocalDateTime dataEnvio;

    private Character status = 'A';

}
