package com.licitacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licitacion.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Long>{

	Persona findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
}
