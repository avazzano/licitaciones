package com.licitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.licitacion.model.Persona;
import com.licitacion.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Persona get(long id) {
		
		return personaRepository.findById(id).get();	
	}

	@Override
	public List<Persona> get() {
		return personaRepository.findAll();
	}

	@Override
	public void insert(Persona entity) {
		
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		entity.setEnable(true);
				
		personaRepository.save(entity);

	}

	@Override
	public void update(Persona entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Persona findByUsername(String username) {
		
		if(personaRepository.existsByUsername(username)){
			return personaRepository.findByUsername(username);
		}
		
		return null;
	}






}
