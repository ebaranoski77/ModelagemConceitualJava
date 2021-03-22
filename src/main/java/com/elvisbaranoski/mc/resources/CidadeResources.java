package com.elvisbaranoski.mc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elvisbaranoski.mc.domain.Cidade;
import com.elvisbaranoski.mc.services.CidadeService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/cidades")


public class CidadeResources{
	@Autowired
	private CidadeService service;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>find(@PathVariable Long id) throws ObjectNotFoundException{
		Cidade obj=service.buscar(id);
		return ResponseEntity.ok().body(obj);    

	}

}






