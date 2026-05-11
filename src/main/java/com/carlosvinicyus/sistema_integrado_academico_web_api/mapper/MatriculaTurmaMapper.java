package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.MatriculaTurmaDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.MatriculaTurma;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MatriculaTurmaMapper {

    @Mapping(source = "aluno.id", target = "alunoId")
    @Mapping(source = "aluno.usuario.nome", target = "alunoNome")
    @Mapping(source = "aluno.matricula", target = "alunoMatricula")
    @Mapping(source = "turma.id", target = "turmaId")
    @Mapping(source = "turma.disciplina.nome", target = "turmaDescricao")
    MatriculaTurmaDTO toDto(MatriculaTurma matricula);

    @Mapping(source = "alunoId", target = "aluno.id")
    @Mapping(source = "turmaId", target = "turma.id")
    MatriculaTurma toEntity(MatriculaTurmaDTO dto);
}
