package com.licitacion.service;

import com.licitacion.model.Persona;

public interface UsuarioService {

	Persona findByUsername(String username);

}
