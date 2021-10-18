package com.treino.jwtreino.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Funcao {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String descricao;
    public Funcao(){}
    public Funcao(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
