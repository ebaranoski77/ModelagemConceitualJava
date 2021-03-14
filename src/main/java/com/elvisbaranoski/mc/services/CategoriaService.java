package com.elvisbaranoski.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elvisbaranoski.mc.domain.Categoria;
import com.elvisbaranoski.mc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	public Categoria buscar(Long id)  {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
		}

}
