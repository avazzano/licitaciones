package com.licitacion.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
	private LocalDateTime fecha;
	
	private Double oferta;
	
	@OneToOne
	private Vehiculo vehiculo;
	
	@OneToOne
	private Usuario usuario;

	@OneToOne
	private Licitacion licitacion;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Double getOferta() {
		return oferta;
	}
	public void setOferta(Double oferta) {
		this.oferta = oferta;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Licitacion getLicitacion() {
		return licitacion;
	}
	public void setLicitacion(Licitacion licitacion) {
		this.licitacion = licitacion;
	}

	
	
	
}
