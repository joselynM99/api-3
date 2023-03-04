package com.example.demo.service.to;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.hateoas.RepresentationModel;

public class VueloBuscarTO extends RepresentationModel<VueloBuscarTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String origen;

	private String destino;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaVuelo;

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	
	

}
