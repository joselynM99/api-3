package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.modelo.Vuelo;

public interface IVueloRepository {
	
	List<Vuelo> buscarVuelosDisponibles(String origen, String destino, LocalDate fechaVuelo);
	
	Vuelo buscarPorNumero(String numero);
	
	void actualizar(Vuelo vuelo);

}
