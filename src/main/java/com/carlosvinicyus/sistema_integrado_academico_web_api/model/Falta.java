package com.carlosvinicyus.sistema_integrado_academico_web_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "falta", schema = "academico")
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matricula_turma_id", nullable = false)
    private MatriculaTurma matriculaTurma;

    @Column(name = "data_aula", nullable = false)
    private LocalDate dataAula;

    private Integer quantidade = 1;
    private String justificativa;

    @Column(name = "codigo_suap", nullable = false, unique = true)
    private String codigoSuap;

}
