package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class CompraTO extends RepresentationModel<CompraTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String numeroTarjeta;

	private Integer cantidadAsientosComprados;

	private String cedulaCliente;
	
	private String numeroVuelo;

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Integer getCantidadAsientosComprados() {
		return cantidadAsientosComprados;
	}

	public void setCantidadAsientosComprados(Integer cantidadAsientosComprados) {
		this.cantidadAsientosComprados = cantidadAsientosComprados;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	
	
}
