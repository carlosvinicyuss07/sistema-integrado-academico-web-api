package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.TurmaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Turma;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TurmaMapper {

    @Mapping(source = "disciplina.id", target = "disciplinaId")
    @Mapping(source = "disciplina.nome", target = "disciplinaNome")
    @Mapping(source = "professor.id", target = "professorId")
    @Mapping(source = "professor.usuario.nome", target = "professorNome")
    @Mapping(source = "periodoLetivo.id", target = "periodoLetivoId")
    @Mapping(source = "periodoLetivo.descricao", target = "periodoLetivoDescricao")
    TurmaDTO toDTO(Turma turma);

    @Mapping(source = "disciplinaId", target = "disciplina.id")
    @Mapping(source = "professorId", target = "professor.id")
    @Mapping(source = "periodoLetivoId", target = "periodoLetivo.id")
    Turma toEntity(TurmaDTO turmaDTO);
}
