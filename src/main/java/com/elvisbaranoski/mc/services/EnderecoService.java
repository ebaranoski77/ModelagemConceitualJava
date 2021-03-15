package com.elvisbaranoski.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elvisbaranoski.mc.domain.Endereco;
import com.elvisbaranoski.mc.repositories.EnderecoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository repository;
	
	public Endereco buscar(Long id) throws ObjectNotFoundException  {
		Optional<Endereco> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
		}
	
	

}
