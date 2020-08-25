package com.licitacion.service;

import com.licitacion.model.Persona;

public interface PersonaService  extends GenericService<Persona> {

	
	public Persona findByUsername(String username);
	
	//public Persona update(Persona usuario, Long id);
	
	
}
