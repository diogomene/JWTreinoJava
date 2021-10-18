package com.treino.jwtreino.services;

import com.treino.jwtreino.domain.Funcao;
import com.treino.jwtreino.domain.Usuario;
import com.treino.jwtreino.repositories.FuncaoRepository;
import com.treino.jwtreino.repositories.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service @Transactional
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
    public UsuarioServiceImpl(UsuarioRepository usuarioRepo, FuncaoRepository funcaoRepo, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.funcaoRepo = funcaoRepo;
        this.passwordEncoder = passwordEncoder;
    }

    private final UsuarioRepository usuarioRepo;
    private final FuncaoRepository funcaoRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        System.out.printf("\nSalvando o usuário %s no banco de dados...\n", usuario);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepo.save(usuario);
    }

    @Override
    public Funcao saveFuncao(Funcao funcao) {
        System.out.printf("\nSalvando a função %s no banco de dados...\n", funcao.getDescricao());
        return funcaoRepo.save(funcao);
    }

    @Override
    public void addFuncaoToUsuario(String username, String descricaoFuncao) {
        System.out.printf("\nAdicionando a função %s ao usuário %s.\n", descricaoFuncao, username);
        Usuario usuario = usuarioRepo.findByUsername(username);
        Funcao funcao = funcaoRepo.findByDescricao(descricaoFuncao);
        usuario.getFuncoes().add(funcao);
    }

    @Override
    public Usuario getUsuario(String username) {
        System.out.printf("\nProcurando informações do usuário %s.\n", username);
        return usuarioRepo.findByUsername(username);
    }

    @Override
    public List<Usuario> getUsuarios() {
        System.out.printf("\nProcurando informações de todos os usuários.\n");
        return usuarioRepo.findAll();
    }

    @Override
    public List<Funcao> getFuncoes() {
        System.out.printf("\nProcurando informações de todas as funções.\n");
        return funcaoRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByUsername(username);
        if(username==null){
            System.out.printf("\nUsuário não encontrado!\n");
            throw  new UsernameNotFoundException("Usário não encontrado");
        }else{
            System.out.printf("\nUsuário enontrado!\n");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getFuncoes().forEach(
                funcao -> {
                    authorities.add(new SimpleGrantedAuthority(funcao.getDescricao()));
                }
        );
        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), authorities);
    }
}
