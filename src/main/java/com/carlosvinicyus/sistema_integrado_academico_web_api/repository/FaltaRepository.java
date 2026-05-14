package com.carlosvinicyus.sistema_integrado_academico_web_api.repository;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Falta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaltaRepository extends JpaRepository<Falta, Long> {
    List<Falta> findByMatriculaTurmaId(Long matriculaTurmaId);
}
