package com.carlosvinicyus.sistema_integrado_academico_web_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "aluno", schema = "academico")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Column(unique = true)
    private String matricula;

    @Column(name = "suap_id", unique = true)
    private String suapId;

    private Character status = 'A';

}
