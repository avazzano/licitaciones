package com.licitacion.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.licitacion.model.Persona;
import com.licitacion.service.PersonaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/persona/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Api(tags ="Endpoint publica usuarios")
public class PersonaResource {

//	@Autowired
//	private  UserAuthenticationService authentication;

	
	@Autowired
	private PersonaService personaService;

	
	@PostMapping("")
	@ApiOperation(value = "Registrar usuario")
	public ResponseEntity<String> register(@RequestBody Persona persona  ) {

		//TODO validaciones
		
		personaService.insert(persona);
		
	    return  ResponseEntity.ok("OK");
	  }
	
	
	@GetMapping("")
	@ApiOperation(value = "Obtener Lista de personas")
	public ResponseEntity<List<Persona>> getVehiculo(){

		List <Persona> personas=personaService.get();
		
		return ResponseEntity.ok(personas);
	
	}
	
	
	
/*	  @PostMapping("/login")
	  @ApiOperation(value = "login usuario")
	  public String login(
	    @RequestParam("username") final String username,
	    @RequestParam("password") final String password) {
	    
		  
		return authentication
	      .login(username, password)
	      .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
	  }
	*/
}
