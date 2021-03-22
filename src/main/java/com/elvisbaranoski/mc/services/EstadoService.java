package com.elvisbaranoski.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elvisbaranoski.mc.domain.Estado;
import com.elvisbaranoski.mc.repositories.EstadoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository repository;

	public Estado buscar(Long id) throws ObjectNotFoundException  {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}



}
