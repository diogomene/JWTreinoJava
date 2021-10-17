package com.treino.jwtreino.services;

import com.treino.jwtreino.domain.Funcao;
import com.treino.jwtreino.domain.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario saveUsuario(Usuario usuario);
    Funcao saveFuncao(Funcao funcao);
    void addFuncaoToUsuario(String username, String descricaoFuncao);
    Usuario getUsuario(String username);
    List<Usuario> getUsuarios();
    List<Funcao> getFuncoes();
}
