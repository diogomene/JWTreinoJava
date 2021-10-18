package com.treino.jwtreino.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private  String nome;
    private  String username;
    private  String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Funcao> funcoes = new ArrayList<Funcao>();
    public Usuario(){}
    public Usuario(Long id, String nome, String username, String password, Collection<Funcao> funcoes) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.funcoes = funcoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(Collection<Funcao> funcoes) {
        this.funcoes = funcoes;
    }
}
