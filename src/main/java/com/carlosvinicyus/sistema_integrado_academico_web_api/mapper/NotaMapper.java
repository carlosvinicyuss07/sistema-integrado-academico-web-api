package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.NotaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Nota;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotaMapper {

    @Mapping(source = "matriculaTurma.id", target = "matriculaTurmaId")
    NotaDTO toDTO(Nota nota);

    @Mapping(source = "matriculaTurmaId", target = "matriculaTurma.id")
    Nota toEntity(NotaDTO notaDTO);
}
