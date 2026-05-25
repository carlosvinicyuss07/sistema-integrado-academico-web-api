package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.ChatTurmaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatTurma;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChatTurmaMapper {
    @Mapping(source = "turma.id", target = "turmaId")
    @Mapping(source = "turma.disciplina.nome", target = "turmaDescricao")
    ChatTurmaDTO toDto(ChatTurma chatTurma);

    @Mapping(source = "turmaId", target = "turma.id")
    ChatTurma toEntity(ChatTurmaDTO chatTurmaDTO);
}
