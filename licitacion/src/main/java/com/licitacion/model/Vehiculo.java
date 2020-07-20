package com.licitacion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
	private String tipo;
	private int interno;
	private int anio;
	private String bateria;
	private int kilometraje;
	private String llaves;
	private String gnc;
	private String marca;
	private String modelo;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getInterno() {
		return interno;
	}
	public void setInterno(int interno) {
		this.interno = interno;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getBateria() {
		return bateria;
	}
	public void setBateria(String bateria) {
		this.bateria = bateria;
	}
	public int getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}
	public String getLlaves() {
		return llaves;
	}
	public void setLlaves(String llaves) {
		this.llaves = llaves;
	}
	public String getGnc() {
		return gnc;
	}
	public void setGnc(String gnc) {
		this.gnc = gnc;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
	
	
}
