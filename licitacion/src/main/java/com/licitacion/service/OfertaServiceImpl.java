package com.licitacion.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licitacion.dto.OfertaDto;
import com.licitacion.model.Oferta;
import com.licitacion.repository.OfertaRepository;

@Service
public class OfertaServiceImpl implements OfertaService {

	@Autowired
	private OfertaRepository ofertaRepository;
	
	@Autowired
	private LicitacionService licitacionService;
	
	@Autowired 
	private VehiculoService vehiculoService;
	

	@Override
	public OfertaDto get(long id) {

		return null;
	}

	@Override
	public List<OfertaDto> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(OfertaDto dto) {
		
		Oferta oferta = new Oferta();
		
		oferta.setVehiculo(vehiculoService.get(dto.getVehiciloId()));
		
		oferta.setLicitacion(licitacionService.get(dto.getLicitacionId()));
		
		oferta.setFecha(LocalDateTime.now());
		
		ofertaRepository.save(oferta);
		
	}

	@Override
	public void update(OfertaDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Oferta> getOfertas(long idLicitacion, long idVehiculo) {
		
		return ofertaRepository.getByLicitacionIdAndVehiculoId(idLicitacion,idVehiculo);
		
	}
	


}
