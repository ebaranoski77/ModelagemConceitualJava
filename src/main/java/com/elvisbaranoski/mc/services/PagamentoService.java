package com.elvisbaranoski.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elvisbaranoski.mc.domain.Pagamento;
import com.elvisbaranoski.mc.repositories.PagamentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PagamentoService {
	@Autowired
	private PagamentoRepository repository;
	
	public Pagamento buscar(Long id) throws ObjectNotFoundException  {
		Optional<Pagamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pagamento.class.getName()));
		}
	
	

}
