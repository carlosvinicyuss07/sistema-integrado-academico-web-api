package com.carlosvinicyus.sistema_integrado_academico_web_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "professor", schema = "academico")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "matricula_siape", unique = true)
    private String matriculaSiape;

    @Column(name = "suap_id", unique = true)
    private String suapId;

    private Character status = 'A';

}
