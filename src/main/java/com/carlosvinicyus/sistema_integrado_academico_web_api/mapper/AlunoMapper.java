package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.AlunoDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlunoMapper {

    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "usuario.nome", target = "usuarioNome")
    @Mapping(source = "curso.id", target = "cursoId")
    @Mapping(source = "curso.nome", target = "cursoNome")
    AlunoDTO toDTO(Aluno aluno);

    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "cursoId", target = "curso.id")
    Aluno toEntity(AlunoDTO alunoDTO);
}
