package com.example.demo.service;

import com.example.demo.service.to.CompraPasajeTO;

public interface IGestionarEmpleadoService {
	
	CompraPasajeTO buscarCompraPorNumero(String numero);
	
	void checkIn(String numero);
	
}
