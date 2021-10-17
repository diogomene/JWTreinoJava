package com.treino.jwtreino.controllers;

import com.treino.jwtreino.services.UsuarioService;

import java.net.URI;
import java.util.List;

import com.treino.jwtreino.domain.Funcao;
import com.treino.jwtreino.domain.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok().body(usuarioService.getUsuarios());
    }

    @PostMapping("/incluir")
    public ResponseEntity<Usuario> incluir(@RequestBody Usuario usuario){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuario/incluir").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.saveUsuario(usuario));
    }


    @PostMapping("/addfuncao")
    public ResponseEntity<?> addFuncao(@RequestBody FuncaoUsuarioForm form){
        usuarioService.addFuncaoToUsuario(form.getUsername(), form.getDescricaoFuncao());
        return ResponseEntity.ok().build();
    }
}

@Data
class FuncaoUsuarioForm{
    private String username;
    private String descricaoFuncao;
}