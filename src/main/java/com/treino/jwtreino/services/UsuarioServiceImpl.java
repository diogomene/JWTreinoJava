package com.treino.jwtreino.services;

import com.treino.jwtreino.domain.Funcao;
import com.treino.jwtreino.domain.Usuario;
import com.treino.jwtreino.repositories.FuncaoRepository;
import com.treino.jwtreino.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository usuarioRepo;
    private final FuncaoRepository funcaoRepo;
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        log.info("Salvando o usuário {} no banco de dados...", usuario);
        return usuarioRepo.save(usuario);
    }

    @Override
    public Funcao saveFuncao(Funcao funcao) {
        log.info("Salvando a função {} no banco de dados...", funcao);
        return funcaoRepo.save(funcao);
    }

    @Override
    public void addFuncaoToUsuario(String username, String descricaoFuncao) {
        log.info("Adicionando a função {} ao usuário {}.", descricaoFuncao, username);
        Usuario usuario = usuarioRepo.findByUsername(username);
        Funcao funcao = funcaoRepo.findByDescricao(descricaoFuncao);
        usuario.getFuncoes().add(funcao);
    }

    @Override
    public Usuario getUsuario(String username) {
        log.info("Procurando informações do usuário {}.", username);
        return usuarioRepo.findByUsername(username);
    }

    @Override
    public List<Usuario> getUsuarios() {
        log.info("Procurando informações de todos os usuários.");
        return usuarioRepo.findAll();
    }

    @Override
    public List<Funcao> getFuncoes() {
        log.info("Procurando informações de todas as funções.");
        return funcaoRepo.findAll();
    }
}
