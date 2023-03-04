package com.example.demo.repository;

import com.example.demo.modelo.Cliente;

public interface IClienteRepository {

	Cliente buscarPorCedula(String cedula);
}
