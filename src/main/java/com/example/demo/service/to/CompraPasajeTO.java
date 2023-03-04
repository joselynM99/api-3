package com.example.demo.service.to;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.hateoas.RepresentationModel;

public class CompraPasajeTO extends RepresentationModel<CompraPasajeTO> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String numero;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaCompra;


	private String numeroTarjeta;


	private Integer cantidadAsientosComprados;


	private String estado;
	
	
	private String cedulaCliente;
	

	private String numeroVuelo;


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public LocalDate getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


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


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
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
