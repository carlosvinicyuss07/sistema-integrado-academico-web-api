package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.PeriodoLetivoDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.PeriodoLetivo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PeriodoLetivoMapper {
    PeriodoLetivoDTO toDTO(PeriodoLetivo periodoLetivo);
    PeriodoLetivo toEntity(PeriodoLetivoDTO periodoLetivoDTO);
}
