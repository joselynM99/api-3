package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IGestionarEmpleadoService;
import com.example.demo.service.to.CompraPasajeTO;

@RestController
@RequestMapping(path = "/empleado")
@CrossOrigin
public class EmpleadoControllerRestFul {
	
	@Autowired
	private IGestionarEmpleadoService gestionarEmpleadoService;
	
	@GetMapping(path = "/comprasPasajes/{numero}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CompraPasajeTO buscarCompraPorNumero(@PathVariable("numero") String numero) {
		return this.gestionarEmpleadoService.buscarCompraPorNumero(numero);
	}
	@PutMapping(path = "/comprasPasajes/{numero}")
	public void checkIn(@PathVariable("numero") String numero) {
		this.gestionarEmpleadoService.checkIn(numero);
	}

}
