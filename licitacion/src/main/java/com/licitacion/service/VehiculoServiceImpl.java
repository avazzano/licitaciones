package com.licitacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licitacion.model.Vehiculo;
import com.licitacion.repository.VehiculoRepositoy;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	private VehiculoRepositoy vehiculoRepositoy;
	
	@Override
	public Vehiculo get(long id) {
		return vehiculoRepositoy.findById(id).get();
	}

	@Override
	public List<Vehiculo> get() {
		return vehiculoRepositoy.findAll();
	}

	@Override
	public void insert(Vehiculo entity) {
		vehiculoRepositoy.save(entity);

	}

	@Override
	public void update(Vehiculo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
