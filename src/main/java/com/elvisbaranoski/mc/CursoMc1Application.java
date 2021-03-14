package com.elvisbaranoski.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elvisbaranoski.mc.domain.Categoria;
import com.elvisbaranoski.mc.domain.Produto;
import com.elvisbaranoski.mc.repositories.CategoriaRepository;
import com.elvisbaranoski.mc.repositories.ProdutoRepository;


@SpringBootApplication
public class CursoMc1Application implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursoMc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null,"INFORMÁTICA");
		Categoria categoria2 =new Categoria(null,"ESCRITÓRIO");
		Produto produto1 = new Produto(null,"COMPUTADOR",2000.00);
		Produto produto2 = new Produto(null,"IMPRESSORA",1000.00);
		Produto produto3 = new Produto(null,"MOUSE",800.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1,categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
		
	}

}
