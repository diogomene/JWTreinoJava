package com.treino.jwtreino.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private  String nome;
    private  String username;
    private  String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Funcao> funcoes = new ArrayList<Funcao>();

}
