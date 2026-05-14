package com.carlosvinicyus.sistema_integrado_academico_web_api.repository;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.PeriodoLetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodoLetivoRepository extends JpaRepository<PeriodoLetivo, Long> {
    List<PeriodoLetivo> findByStatus(Character status);
}
