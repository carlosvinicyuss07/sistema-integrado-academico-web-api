package com.carlosvinicyus.sistema_integrado_academico_web_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "nota", schema = "academico")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matricula_turma_id", nullable = false)
    private MatriculaTurma matriculaTurma;

    private String descricao;
    private BigDecimal valor;
    private BigDecimal peso;

    @Column(name = "data_avaliacao")
    private LocalDate dataAvaliacao;

    @Column(name = "codigo_suap", nullable = false, unique = true)
    private String codigoSuap;

}
