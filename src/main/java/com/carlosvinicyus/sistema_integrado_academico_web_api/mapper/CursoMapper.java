package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.CursoDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CursoMapper {
    CursoDTO toDTO(Curso curso);
    Curso toEntity(CursoDTO cursoDTO);
}
