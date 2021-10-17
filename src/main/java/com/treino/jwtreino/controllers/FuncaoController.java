package com.treino.jwtreino.controllers;

import com.treino.jwtreino.services.UsuarioService;

import java.net.URI;
import java.util.List;

import com.treino.jwtreino.domain.Funcao;
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
