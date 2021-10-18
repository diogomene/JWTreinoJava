package com.treino.jwtreino.controllers;

import com.treino.jwtreino.domain.Funcao;
import com.treino.jwtreino.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcao")
@RequiredArgsConstructor
public class FuncaoController {
    private final UsuarioService usuarioService;
    @GetMapping("/listar")
    public ResponseEntity<List<Funcao>> listar(){
        
        return ResponseEntity.ok().body(usuarioService.getFuncoes());
    }

    @PostMapping("/incluir")
    public ResponseEntity<Funcao> incluir(@RequestBody Funcao funcao){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/funcao/incluir").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.saveFuncao(funcao));
    }
}
