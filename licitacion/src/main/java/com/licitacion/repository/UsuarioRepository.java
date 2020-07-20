package com.licitacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licitacion.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

	Optional<Usuario> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
}
