package com.carlosvinicyus.sistema_integrado_academico_web_api.repository;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatMensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensagemRepository extends JpaRepository<ChatMensagem, Long> {

    @Query("SELECT m FROM ChatMensagem m WHERE m.chatTurma.id = :chatTurmaId AND m.status = :status ORDER BY m.dataEnvio ASC")
    List<ChatMensagem> obterHistoricoDoChat(@Param("chatTurmaId") Long chatTurmaId, @Param("status") Character status);
}
