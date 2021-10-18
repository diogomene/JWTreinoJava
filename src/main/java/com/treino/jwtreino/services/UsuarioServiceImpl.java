package com.treino.jwtreino.services;

import com.treino.jwtreino.domain.Funcao;
import com.treino.jwtreino.domain.Usuario;
import com.treino.jwtreino.repositories.FuncaoRepository;
import com.treino.jwtreino.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service @Transactional
public class UsuarioServiceImpl implements UsuarioService{
    public UsuarioServiceImpl(UsuarioRepository usuarioRepo, FuncaoRepository funcaoRepo) {
        this.usuarioRepo = usuarioRepo;
        this.funcaoRepo = funcaoRepo;
    }

    private final UsuarioRepository usuarioRepo;
    private final FuncaoRepository funcaoRepo;
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        System.out.printf("\nSalvando o usuário %s no banco de dados...", usuario);
        return usuarioRepo.save(usuario);
    }

    @Override
    public Funcao saveFuncao(Funcao funcao) {
        System.out.printf("\nSalvando a função %s no banco de dados...", funcao.getDescricao());
        return funcaoRepo.save(funcao);
    }

    @Override
    public void addFuncaoToUsuario(String username, String descricaoFuncao) {
        System.out.printf("Adicionando a função %s ao usuário %s.", descricaoFuncao, username);
        Usuario usuario = usuarioRepo.findByUsername(username);
        Funcao funcao = funcaoRepo.findByDescricao(descricaoFuncao);
        usuario.getFuncoes().add(funcao);
    }

    @Override
    public Usuario getUsuario(String username) {
        System.out.printf("Procurando informações do usuário %s.", username);
        return usuarioRepo.findByUsername(username);
    }

    @Override
    public List<Usuario> getUsuarios() {
        System.out.printf("Procurando informações de todos os usuários.");
        return usuarioRepo.findAll();
    }

    @Override
    public List<Funcao> getFuncoes() {
        System.out.printf("Procurando informações de todas as funções.");
        return funcaoRepo.findAll();
    }

}
