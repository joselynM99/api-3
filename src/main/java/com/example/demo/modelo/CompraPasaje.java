package com.example.demo.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "compra_pasaje")
public class CompraPasaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_compra_pasaje")
	@SequenceGenerator(name = "seq_compra_pasaje", sequenceName = "seq_compra_pasaje", allocationSize = 1)
	@Column(name = "copa_id")
	private Integer id;
	
	@Column(name = "copa_numero")
	private String numero;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "copa_fecha_compra")
	private LocalDate fechaCompra;

	@Column(name = "copa_numero_tarjeta")
	private String numeroTarjeta;

	@Column(name = "copa_cantidad_asientos_comprados")
	private Integer cantidadAsientosComprados;

	@Column(name = "copa_estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "clie_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "vuel_id")
	private Vuelo vuelo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	
	

}
