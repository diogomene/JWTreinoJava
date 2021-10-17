package com.treino.jwtreino.repositories;

import com.treino.jwtreino.domain.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Long> {
    Funcao findByDescricao(String descricao);
}
