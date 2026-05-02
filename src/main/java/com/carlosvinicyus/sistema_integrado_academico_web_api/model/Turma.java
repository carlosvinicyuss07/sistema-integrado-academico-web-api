package com.carlosvinicyus.sistema_integrado_academico_web_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "turma", schema = "academico")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "periodo_letivo_id", nullable = false)
    private PeriodoLetivo periodoLetivo;

    private String descricao;

    @Column(name = "codigo_suap", unique = true)
    private String codigoSuap;

    private Character status = 'A';
}
