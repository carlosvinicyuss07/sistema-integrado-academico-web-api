package com.carlosvinicyus.sistema_integrado_academico_web_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "chat_turma", schema = "academico")
public class ChatTurma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;

    private String titulo;
    private Character status = 'A';

    @Column(name = "criacao", insertable = false, updatable = false)
    private LocalDate dataCriacao;

}
