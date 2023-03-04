package com.example.demo.service.to;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.hateoas.RepresentationModel;

public class AsientosTO extends RepresentationModel<AsientosTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numero;

	private Integer asientosDisponibles;

	private Integer asientosOcupados;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	public Integer getAsientosOcupados() {
		return asientosOcupados;
	}

	public void setAsientosOcupados(Integer asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}
	
	

}
