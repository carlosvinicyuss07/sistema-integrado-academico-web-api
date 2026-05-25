package com.carlosvinicyus.sistema_integrado_academico_web_api.model;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.enums.PerfilUsuarioEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "usuario", schema = "academico")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private PerfilUsuarioEnum perfil;

    @Column(name = "suap_id", nullable = false, unique = true)
    private String suapId;

    private Character status = 'A'; // A = Ativo, I = Inativo

    @Column(name = "data_cadastro", insertable = false, updatable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

}
