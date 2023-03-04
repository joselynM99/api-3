package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IGestionarClienteService;
import com.example.demo.service.to.AsientosTO;
import com.example.demo.service.to.CompraTO;
import com.example.demo.service.to.VueloBuscarTO;
import com.example.demo.service.to.VueloDisponibleTO;

@RestController
@RequestMapping(path = "/cliente")
@CrossOrigin
public class ClienteControllerRestFul {
	
	@Autowired
	private IGestionarClienteService gestionarClienteService;

	@PostMapping(path = "/vuelosDisponibles", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<VueloDisponibleTO> buscarVuelosDisponibles(@RequestBody VueloBuscarTO vuelo) {
		return this.gestionarClienteService.buscarVuelosDisponibles(vuelo);
	}
	
	@GetMapping(path = "/vuelosDisponibles/{numero}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public AsientosTO buscarVuelo(@PathVariable("numero") String numero) {
		return this.gestionarClienteService.buscarVuelo(numero);
		
	}
	
	@PostMapping(path="/reservar")
	public void reservar(@RequestBody CompraTO compra) {
		this.gestionarClienteService.reservar(compra);
	}
}
