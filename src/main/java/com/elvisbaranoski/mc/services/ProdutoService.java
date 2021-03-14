package com.elvisbaranoski.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elvisbaranoski.mc.domain.Categoria;
import com.elvisbaranoski.mc.domain.Produto;
import com.elvisbaranoski.mc.repositories.CategoriaRepository;
import com.elvisbaranoski.mc.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	public Produto buscar(Long id)  {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElse(null);
		}

}
