package com.danieldelfim.cursomct;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danieldelfim.cursomct.domain.Categoria;
import com.danieldelfim.cursomct.domain.Cidade;
import com.danieldelfim.cursomct.domain.Cliente;
import com.danieldelfim.cursomct.domain.Endereco;
import com.danieldelfim.cursomct.domain.Estado;
import com.danieldelfim.cursomct.domain.Produto;
import com.danieldelfim.cursomct.domain.enuns.TipoCliente;
import com.danieldelfim.cursomct.repositories.CategoriaRepository;
import com.danieldelfim.cursomct.repositories.CidadeRepository;
import com.danieldelfim.cursomct.repositories.ClienteRepository;
import com.danieldelfim.cursomct.repositories.EnderecoRepository;
import com.danieldelfim.cursomct.repositories.EstadoRepository;
import com.danieldelfim.cursomct.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomctApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomctApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Categoria cat1 = new Categoria(null, "Informática"); // null pois id gerado automatico
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		// preciso salvar estes dados no BD. Somente Repository pode e por isso coloca
		// uma dependencia dele

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "maria", "maria@gmail.com", "1234565789", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("1234524563", "2346745353"));

		Endereco e1 = new Endereco(null, "rua flores", "300", "apto303", "jardim", "32493432", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida matos", "105", "sl 800", "centro", "39894532", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

	}

}
