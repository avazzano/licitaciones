package com.licitacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licitacion.model.Licitacion;

public interface LicitacionRepository extends JpaRepository<Licitacion,Long>{

}
