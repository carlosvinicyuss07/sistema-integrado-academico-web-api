package com.carlosvinicyus.sistema_integrado_academico_web_api.service;

import com.carlosvinicyus.sistema_integrado_academico_web_api.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario buscarPorId(Long id);
    Usuario buscarPorSuapId(String suapId);
    List<Usuario> listarTodos();
    Usuario salvar(Usuario usuario);
}
