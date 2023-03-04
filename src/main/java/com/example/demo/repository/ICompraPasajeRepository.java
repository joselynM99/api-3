package com.example.demo.repository;

import com.example.demo.modelo.CompraPasaje;

public interface ICompraPasajeRepository {
	
	void insertar(CompraPasaje compra);

	void actualizar(CompraPasaje compra);

	CompraPasaje buscarPorNumero(String numero);

}
