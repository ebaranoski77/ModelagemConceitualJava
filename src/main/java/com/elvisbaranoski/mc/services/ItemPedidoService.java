package com.elvisbaranoski.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elvisbaranoski.mc.domain.ItemPedido;
import com.elvisbaranoski.mc.repositories.ItemPedidoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ItemPedidoService {
	@Autowired
	private ItemPedidoRepository repository;

	public ItemPedido buscar(Long id) throws ObjectNotFoundException  {
		Optional<ItemPedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ItemPedido.class.getName()));
	}



}
