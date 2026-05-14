package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.FaltaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Falta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FaltaMapper {

    @Mapping(source = "matriculaTurma.id", target = "matriculaTurmaId")
    FaltaDTO toDTO(Falta falta);

    @Mapping(source = "matriculaTurmaId", target = "matriculaTurma.id")
    Falta toEntity(FaltaDTO faltaDTO);
}
