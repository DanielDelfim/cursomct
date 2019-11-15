package com.danieldelfim.cursomct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danieldelfim.cursomct.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
//com estas anotações será possível acessar e fazer operações no banco de dados.
}
