package com.carlosvinicyus.sistema_integrado_academico_web_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "disciplina", schema = "academico")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigo;

    @Column(name = "codigo_suap", unique = true)
    private String codigoSuap;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    private Character status = 'A';

}
