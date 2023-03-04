package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.AsientosTO;
import com.example.demo.service.to.CompraTO;
import com.example.demo.service.to.VueloBuscarTO;
import com.example.demo.service.to.VueloDisponibleTO;

public interface IGestionarClienteService {
	
	List<VueloDisponibleTO> buscarVuelosDisponibles(VueloBuscarTO vuelo);
	
	AsientosTO buscarVuelo(String numero);
	
	void reservar(CompraTO compra);
	

}
