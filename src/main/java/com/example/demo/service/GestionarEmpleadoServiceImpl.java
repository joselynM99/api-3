package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CompraPasaje;
import com.example.demo.repository.ICompraPasajeRepository;
import com.example.demo.service.to.CompraPasajeTO;

@Service
public class GestionarEmpleadoServiceImpl implements IGestionarEmpleadoService{
	
	@Autowired
	private ICompraPasajeRepository compraPasajeRepository;

	@Override
	public CompraPasajeTO buscarCompraPorNumero(String numero) {
		return this.convertirCompraACompraPasajeTO(this.compraPasajeRepository.buscarPorNumero(numero));
	}

	@Override
	public void checkIn(String numero) {
		CompraPasaje c = this.compraPasajeRepository.buscarPorNumero(numero);
		c.setEstado("I");
		c.setId(c.getId());
		this.compraPasajeRepository.actualizar(c);
	}
	
	
private CompraPasajeTO convertirCompraACompraPasajeTO(CompraPasaje compra) {
	CompraPasajeTO c = new CompraPasajeTO();
	
	c.setCantidadAsientosComprados(compra.getCantidadAsientosComprados());
	c.setCedulaCliente(compra.getCliente().getCedula());
	c.setEstado(compra.getEstado());
	c.setFechaCompra(compra.getFechaCompra());
	c.setNumero(compra.getNumero());
	c.setNumeroTarjeta(compra.getNumeroTarjeta());
	c.setNumeroVuelo(compra.getVuelo().getNumero());
	return c;
}
}
