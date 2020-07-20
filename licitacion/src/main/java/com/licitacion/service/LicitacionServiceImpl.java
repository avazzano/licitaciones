package com.licitacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licitacion.model.Licitacion;
import com.licitacion.model.Vehiculo;
import com.licitacion.repository.LicitacionRepository;
import com.licitacion.repository.VehiculoRepositoy;

@Service
public class LicitacionServiceImpl implements LicitacionService {
	
	
	@Autowired
	private LicitacionRepository licitacionRepository;
	
	@Autowired
	private VehiculoRepositoy vehiculoRepository;

	@Override
	public Licitacion get(long id) {
		
		return licitacionRepository.getOne(id);
	}

	@Override
	public List<Licitacion> get() {
		return licitacionRepository.findAll();
	}

	@Override
	public void insert(Licitacion entity) {
		entity.setVehiculos(new ArrayList<>());
		licitacionRepository.save(entity);

	}

	@Override
	public void update(Licitacion entity) {
		licitacionRepository.save(entity);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addVehiculo(long id, List<Long> vehiculosId) {
		
		for (Long vehiculo : vehiculosId) {
			this.addVehiculo(id, vehiculo);
		}
		
		
	}

	@Override
	public void addVehiculo(long id, Long vehiculoId) {
				
		Licitacion licitacion = licitacionRepository.getOne(id);
		
		Vehiculo vehiculo = vehiculoRepository.getOne(vehiculoId);
		
		licitacion.getVehiculos().add(vehiculo);
		
		licitacionRepository.save(licitacion);
		
	}

}
