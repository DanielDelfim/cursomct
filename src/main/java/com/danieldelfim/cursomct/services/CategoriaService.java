package com.danieldelfim.cursomct.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieldelfim.cursomct.domain.Categoria;
import com.danieldelfim.cursomct.repositories.CategoriaRepository;
import com.danieldelfim.cursomct.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired //instancia automaticamente a dependência dentro de uma classe. Dá acesso
	private CategoriaRepository repo;
	
	//agora precisamos usar o objeto repo para ir no banco de dados e buscar uma categoria conforme ID
	
	public Categoria buscar(Integer id) { //método buscar tem que receber o id como parâmetro
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:"+ id +"Tipo:"+Categoria.class.getName()));
	}
	
}
