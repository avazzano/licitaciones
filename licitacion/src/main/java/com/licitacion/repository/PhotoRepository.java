package com.licitacion.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.licitacion.model.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> {
	
	List<Photo> findByVehiculoId(Long id);

}