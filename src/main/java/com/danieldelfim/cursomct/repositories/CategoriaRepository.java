package com.danieldelfim.cursomct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danieldelfim.cursomct.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
//com estas anotações será possível acessar e fazer operações no banco de dados.
}
