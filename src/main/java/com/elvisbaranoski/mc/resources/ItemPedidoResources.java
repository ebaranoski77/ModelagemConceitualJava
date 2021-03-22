package com.elvisbaranoski.mc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elvisbaranoski.mc.domain.ItemPedido;
import com.elvisbaranoski.mc.services.ItemPedidoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/itempedidos")


public class ItemPedidoResources{
	@Autowired
	private ItemPedidoService service;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>find(@PathVariable Long id) throws ObjectNotFoundException{
		ItemPedido obj=service.buscar(id);
		return ResponseEntity.ok().body(obj);    

	}

}






