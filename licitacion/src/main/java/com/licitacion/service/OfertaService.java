package com.licitacion.service;

import java.util.List;

import com.licitacion.dto.OfertaDto;
import com.licitacion.model.Oferta;

public interface OfertaService extends GenericService<OfertaDto> {

	List<Oferta> getOfertas(long idLicitacion, long idVehiculo);

}
