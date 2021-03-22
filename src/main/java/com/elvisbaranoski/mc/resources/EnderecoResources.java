package com.elvisbaranoski.mc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elvisbaranoski.mc.domain.Endereco;
import com.elvisbaranoski.mc.services.EnderecoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/enderecos")


public class EnderecoResources{
	@Autowired
	private EnderecoService service;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>find(@PathVariable Long id) throws ObjectNotFoundException{
		Endereco obj=service.buscar(id);
		return ResponseEntity.ok().body(obj);    

	}

}






