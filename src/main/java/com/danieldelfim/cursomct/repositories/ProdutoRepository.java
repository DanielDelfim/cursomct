package com.danieldelfim.cursomct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danieldelfim.cursomct.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
//com estas anotações será possível acessar e fazer operações no banco de dados.
}
