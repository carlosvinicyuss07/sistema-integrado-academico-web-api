package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.DisciplinaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DisciplinaMapper {
    DisciplinaDTO toDto(Disciplina disciplina);
    Disciplina toEntity(DisciplinaDTO disciplinaDTO);
}
