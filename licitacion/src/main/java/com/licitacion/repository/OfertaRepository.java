package com.licitacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.licitacion.model.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta,Long>{
	
	@Query("Select oferta from Oferta oferta where oferta.licitacion.id = :licitacionId and oferta.vehiculo.id = :vehiculoId")
	public List<Oferta> getByLicitacionIdAndVehiculoId(@Param("licitacionId") long licitacionId, @Param("vehiculoId") long vehiculoId);

}
