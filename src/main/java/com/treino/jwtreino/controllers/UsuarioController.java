package com.treino.jwtreino.controllers;

import com.treino.jwtreino.domain.Usuario;
import com.treino.jwtreino.services.UsuarioService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    private final UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok().body(usuarioService.getUsuarios());
    }

    @GetMapping("/procurar/{usuario}")
    public ResponseEntity<Usuario> procurar(@PathVariable("usuario") String usuario){
        return ResponseEntity.ok().body(usuarioService.getUsuario(usuario));
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