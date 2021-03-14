package com.elvisbaranoski.mc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elvisbaranoski.mc.domain.Categoria;

@RestController
public class CategoriaResources{
	@RequestMapping(value = "/categorias", method = RequestMethod.GET)
	public List<Categoria> listar() {
	    Categoria categoria1= new Categoria(1L,"INFORMÁTICA");
	    Categoria categoria2= new Categoria(2L,"ESCRITÓRIO");
	    
	    List<Categoria> lista= new ArrayList<>();
	    	
	      lista.add(categoria1);
	      lista.add(categoria2);
	      
	      return lista;
	    
		}
	
	}
	





