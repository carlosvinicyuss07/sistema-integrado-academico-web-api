package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.UsuarioDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    UsuarioDTO toDTO(Usuario usuario);

    @Mapping(target = "senha", ignore = true) // Ignora o campo senha ao mapear de DTO para entidade
    Usuario toEntity(UsuarioDTO usuarioDTO);
}
