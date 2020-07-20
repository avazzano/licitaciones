package com.licitacion.service;

import com.licitacion.model.Usuario;

public interface UsuarioService  extends GenericService<Usuario> {

	
	public Usuario findByUsername(String username);
	
	public Usuario update(Usuario usuario, Long id);
}
