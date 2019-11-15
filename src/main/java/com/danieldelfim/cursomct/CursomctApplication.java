package com.danieldelfim.cursomct;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danieldelfim.cursomct.domain.Categoria;
import com.danieldelfim.cursomct.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomctApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomctApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Informática"); //null pois id gerado automatico
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//preciso salvar estes dados no BD. Somente Repository pode e por isso coloca uma dependencia dele
	
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	
	}

}
