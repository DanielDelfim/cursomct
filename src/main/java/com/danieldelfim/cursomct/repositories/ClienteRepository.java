package com.danieldelfim.cursomct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danieldelfim.cursomct.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
//com estas anotações será possível acessar e fazer operações no banco de dados.
}
