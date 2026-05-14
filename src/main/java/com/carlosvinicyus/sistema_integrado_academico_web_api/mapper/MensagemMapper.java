package com.carlosvinicyus.sistema_integrado_academico_web_api.mapper;

import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.MensagemRequestDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.dto.MensagemResponseDTO;
import com.carlosvinicyus.sistema_integrado_academico_web_api.model.ChatMensagem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MensagemMapper {

    @Mapping(source = "chatTurma.id", target = "chatTurmaId")
    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "usuario.nome", target = "remetenteNome")
    MensagemResponseDTO toDTO(ChatMensagem mensagem);

    ChatMensagem toEntity(MensagemRequestDTO mensagemRequestDTO);
}
