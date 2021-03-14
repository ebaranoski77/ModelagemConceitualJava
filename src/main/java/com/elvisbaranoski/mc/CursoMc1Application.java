package com.elvisbaranoski.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elvisbaranoski.mc.domain.Categoria;
import com.elvisbaranoski.mc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoMc1Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursoMc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 =new Categoria(null,"INFORMÁTICA");
		Categoria categoria2 =new Categoria(null,"ESCRITÓRIO");
		
		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
	}

}
