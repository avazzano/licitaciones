package com.licitacion.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.licitacion.dto.OfertaDto;
import com.licitacion.model.Oferta;
import com.licitacion.service.OfertaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ofertas/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Api(tags ="Endpoint Ofertas")
public class OfertaResource {

	@Autowired
	private OfertaService ofertaService;
	
	@GetMapping("{idLicitacion}/{idVehiculo}")
	@ApiOperation(value = "Obtener ofertas por licitacion y vehiculo")
	public ResponseEntity<List<Oferta>> getOferta(@PathVariable long idLicitacion, @PathVariable long idVehiculo) {
		 
		
		List<Oferta> ofertas= ofertaService.getOfertas(idLicitacion,idVehiculo);
			
				
		return ResponseEntity.ok(ofertas);
	}
	
	
	@PostMapping
	@ApiOperation(value = "Alta Oferta ")
	public ResponseEntity<String> addOferta(@RequestBody OfertaDto dto){
		
		ofertaService.insert(dto);
		
		return ResponseEntity.ok("OK");
	}
	

}
