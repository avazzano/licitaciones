package com.licitacion.dto;

public class OfertaDto {

	private Double monto;
	
	private long vehiciloId;
	
	private long licitacionId;

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public long getVehiciloId() {
		return vehiciloId;
	}

	public void setVehiciloId(long vehiciloId) {
		this.vehiciloId = vehiciloId;
	}

	public long getLicitacionId() {
		return licitacionId;
	}

	public void setLicitacionId(long licitacionId) {
		this.licitacionId = licitacionId;
	}
	
	
}
