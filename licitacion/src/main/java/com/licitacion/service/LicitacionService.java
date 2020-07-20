package com.licitacion.service;

import java.util.List;

import com.licitacion.model.Licitacion;

public interface LicitacionService extends GenericService<Licitacion>{

	void addVehiculo(long id, List<Long> vehiculosId);
	
	void addVehiculo(long id, Long vehiculoId);

	
	
	
}
