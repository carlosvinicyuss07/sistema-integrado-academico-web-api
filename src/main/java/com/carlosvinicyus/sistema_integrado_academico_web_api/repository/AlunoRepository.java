package com.carlosvinicyus.sistema_integrado_academico_web_api.repository;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByUsuarioId(Long usuarioId);
}