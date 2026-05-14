package com.carlosvinicyus.sistema_integrado_academico_web_api.repository;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.MatriculaTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaTurmaRepository extends JpaRepository<MatriculaTurma, Long> {
    List<MatriculaTurma> findByAlunoId(Long alunoId);

    List<MatriculaTurma> findByTurmaId(Long turmaId);

    @Query(value = """
             SELECT COUNT(*)
             FROM academico.matricula_turma
             WHERE turma_id = :turmaId
               AND situacao = 'CURSANDO'
               AND status = 'A'
            """,
            nativeQuery = true)
    Integer contarAlunosAtivosNaTurma(@Param("turmaId") Long turmaId);
}
