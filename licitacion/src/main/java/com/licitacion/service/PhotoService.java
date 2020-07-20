package com.licitacion.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.licitacion.model.Photo;
import com.licitacion.model.Vehiculo;
import com.licitacion.repository.PhotoRepository;



@Service
public class PhotoService {
 
    @Autowired
    private PhotoRepository photoRepo;
    
    @Autowired
    private VehiculoService vehiculoService;
 
    public String addPhoto(String title, MultipartFile file, long IdVehiculo) throws IOException { 
    	
    	Vehiculo v=vehiculoService.get(IdVehiculo);
    	
    	Photo photo = new Photo(title); 
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        photo.setVehiculoId(v.getId());
        
        photo = photoRepo.insert(photo); return photo.getId(); 
    }
 
    public Photo getPhoto(String id) { 
        return photoRepo.findById(id).get(); 
    }

	public  List<String> getFotosIds(long idVehiculo) {
		
		List<String> ids=new ArrayList<String>();
		List<Photo> photos=  photoRepo.findByVehiculoId(idVehiculo);
		for (Photo photo : photos) {
			ids.add(photo.getId());
		}
		
		return ids;
	}
}