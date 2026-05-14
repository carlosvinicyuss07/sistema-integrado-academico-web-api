package com.carlosvinicyus.sistema_integrado_academico_web_api.repository;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatTurmaRepository extends JpaRepository<ChatTurma, Long> {
    Optional<ChatTurma> findByTurmaId(Long turmaId);
}
