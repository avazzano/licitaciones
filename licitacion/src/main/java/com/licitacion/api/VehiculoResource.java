package com.licitacion.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.licitacion.model.Photo;
import com.licitacion.model.Vehiculo;
import com.licitacion.service.PhotoService;
import com.licitacion.service.VehiculoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/vehiculos/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Api(tags ="Endpoint Vehiculos")
public class VehiculoResource {
	
	@Autowired 
	VehiculoService vehiculoService;
		
	@Autowired
	PhotoService photoService;
	
	
	@GetMapping("{id}")
	@ApiOperation(value = "Obtener Vehiculo por id")
	public ResponseEntity<Vehiculo> getVehiculo(@PathVariable long id) {
		 
		Vehiculo vehiculo = vehiculoService.get(id);
		
		return ResponseEntity.ok(vehiculo);
	}
	
	
	@GetMapping("")
	@ApiOperation(value = "Obtener Vehiculo por filtro")
	public ResponseEntity<List<Vehiculo>> getVehiculo(){

		List <Vehiculo> vehiculos=vehiculoService.get();
		
		return ResponseEntity.ok(vehiculos);
	
	}
	
	
	@PostMapping
	@ApiOperation(value = "Alta Vehiculo ")
	public ResponseEntity<String> addVehiculo(@RequestBody Vehiculo vehiculo){
		
		vehiculoService.insert(vehiculo);
		
		return ResponseEntity.ok("OK");
	}
	
	
	@PutMapping
	@ApiOperation(value = "Modificacion Vehiculo ")
	public ResponseEntity<String> updateVehiculo(@RequestBody Vehiculo vehiculo){
		
		vehiculoService.update(vehiculo);
		
		return ResponseEntity.ok("OK");
	}
	
	
	@ApiOperation(value = "Alta Foto para Vehiculo ")
	@PostMapping("photos/add")
	public ResponseEntity<String> addPhoto( @RequestParam("id") String idVehiculo, @RequestParam("title") String title, 
	  @RequestParam("image") MultipartFile image, Model model) 
	  throws IOException {
		
		Long idV=Long.parseLong(idVehiculo);
	    String id = photoService.addPhoto(title, image, idV);
	    return ResponseEntity.ok("OK");
	}
	
	@ApiOperation(value = "Get fotos para Vehiculo ")
	@GetMapping("{id}/photos")
	@ResponseBody
	public ResponseEntity<List<String>> getPhotosID(@PathVariable long id){		
	    
		return ResponseEntity.ok(photoService.getFotosIds(id));
	 
	}
	
	@ApiOperation(value = "Get foto")
	@GetMapping(value="photos/{id}")
	@ResponseBody
	public HttpEntity<byte[]> getPhoto(@PathVariable String id, Model model) {
	    Photo photo = photoService.getPhoto(id);

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    headers.setContentLength(photo.getImage().getData().length);
	    
	    

	    return new HttpEntity<byte[]>(photo.getImage().getData(), headers);
	}
	
	
	

}
