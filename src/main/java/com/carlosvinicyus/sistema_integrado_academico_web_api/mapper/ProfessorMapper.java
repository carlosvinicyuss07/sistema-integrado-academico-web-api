package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.ProfessorDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfessorMapper {

    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "usuario.nome", target = "usuarioNome")
    ProfessorDTO toDTO(Professor professor);

    @Mapping(source = "usuarioId", target = "usuario.id")
    Professor toEntity(ProfessorDTO professorDTO);
}
