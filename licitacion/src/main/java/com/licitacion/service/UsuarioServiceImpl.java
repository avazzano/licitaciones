package com.licitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licitacion.model.Usuario;
import com.licitacion.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Usuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Usuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario usuario, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
