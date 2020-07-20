package com.licitacion.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.licitacion.model.Licitacion;
import com.licitacion.service.LicitacionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/licitaciones/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Api(tags ="Endpoint Licitacion")
public class LicitacionResource {

	
	@Autowired 
	private LicitacionService licitacionService;
	
	@GetMapping("{id}")
	@ApiOperation(value = "Obtener Licitacitacion por id")
	public ResponseEntity<Licitacion> getLicitacion(@PathVariable long id) {
		 
		Licitacion licicitacion = licitacionService.get(id);
		
		return ResponseEntity.ok(licicitacion);
	}
	
	
	@GetMapping("")
	@ApiOperation(value = "Obtener persona por filtro")
	public ResponseEntity<List<Licitacion>> getLicitacion(){

		List <Licitacion> personas=licitacionService.get();
		
		return ResponseEntity.ok(personas);
	
	}
	
	
	@PostMapping
	@ApiOperation(value = "Alta licitacion")
	public ResponseEntity<String> addLicitacion(@RequestBody Licitacion licitacion){
		
		licitacionService.insert(licitacion);
		
		return  ResponseEntity.ok("OK");
		
	}
	
	
	@PutMapping
	@ApiOperation(value = "Modificacion licitacion")
	public ResponseEntity<String> uodateLicitacion(@RequestBody Licitacion licitacion){
		
		licitacionService.insert(licitacion);
		
		return  ResponseEntity.ok("OK");
		
	}
	
	
	@PatchMapping("{id}/addVehiculo")
	@ApiOperation(value = "Agrega vehiculo a licitacion")
	public ResponseEntity<String> addVehiculo(@PathVariable long id, @RequestBody List<Long> vehiculos){
		
		licitacionService.addVehiculo(id, vehiculos);
		
		return  ResponseEntity.ok("OK");
		
	}
	
	
	
	
	
	
}
