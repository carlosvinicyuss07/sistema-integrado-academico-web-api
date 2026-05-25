package com.carlosvinicyus.sistema_integrado_academico_web_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "curso", schema = "academico")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "codigo_suap", nullable = false, unique = true)
    private String codigoSuap;

    private Character status = 'A';

}
