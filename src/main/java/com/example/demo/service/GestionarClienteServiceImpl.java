package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CompraPasaje;
import com.example.demo.modelo.Vuelo;
import com.example.demo.repository.IAvionRepositoryImpl;
import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.ICompraPasajeRepository;
import com.example.demo.repository.IVueloRepository;
import com.example.demo.service.to.AsientosTO;
import com.example.demo.service.to.CompraTO;
import com.example.demo.service.to.VueloBuscarTO;
import com.example.demo.service.to.VueloDisponibleTO;

@Service
public class GestionarClienteServiceImpl implements IGestionarClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IAvionRepositoryImpl avionRepositoryImpl;

	@Autowired
	private IVueloRepository vueloRepository;

	@Autowired
	private ICompraPasajeRepository compraPasajeRepository;

	@Override
	public List<VueloDisponibleTO> buscarVuelosDisponibles(VueloBuscarTO vuelo) {
		
		List<Vuelo> listaVuelos = this.vueloRepository.buscarVuelosDisponibles(vuelo.getOrigen(), vuelo.getDestino(), vuelo.getFechaVuelo());

		List<VueloDisponibleTO> listaFinal = listaVuelos.stream().map(v -> this.convertirVueloAVueloDisponibleTO(v))
				.collect(Collectors.toList());

		return listaFinal;
		
	}

	@Override
	public AsientosTO buscarVuelo(String numero) {
		return this.convertirVueloAAsientosTO(this.vueloRepository.buscarPorNumero(numero));
	}

	@Override
	public void reservar(CompraTO compra) {
		CompraPasaje c = new CompraPasaje();
		c.setCantidadAsientosComprados(compra.getCantidadAsientosComprados());
		c.setCliente(this.clienteRepository.buscarPorCedula(compra.getCedulaCliente()));
		c.setEstado("R");
		c.setFechaCompra(LocalDate.now());
		c.setNumero("001-"+(Math.random()*10000)*(Math.random()*10000));
		c.setNumeroTarjeta(compra.getNumeroTarjeta());
		System.out.println(compra.getNumeroTarjeta());
		Vuelo v = this.vueloRepository.buscarPorNumero(compra.getNumeroVuelo());
		v.setAsientosDisponibles(v.getAsientosDisponibles()-compra.getCantidadAsientosComprados());
		v.setAsientosOcupados(v.getAsientosOcupados()+compra.getCantidadAsientosComprados());
		
		if(v.getAsientosDisponibles()<=0) {
			v.setEstado("ND");
		}
		v.setId(v.getId());
		this.vueloRepository.actualizar(v);
		c.setVuelo(v);
		this.compraPasajeRepository.insertar(c);
		

	}
	
	private VueloDisponibleTO convertirVueloAVueloDisponibleTO(Vuelo vuelo) {
		VueloDisponibleTO v = new VueloDisponibleTO();
		v.setCategoria(vuelo.getCategoria());
		v.setDestino(vuelo.getDestino());
		v.setNombreAvion(vuelo.getAvion().getNombre());
		v.setNumero(vuelo.getNumero());
		v.setOrigen(vuelo.getOrigen());
		v.setValorAsiento(vuelo.getValorAsiento());
		
		return v;
	}
	
	private AsientosTO convertirVueloAAsientosTO(Vuelo vuelo) {
		AsientosTO v = new AsientosTO();
		v.setAsientosDisponibles(vuelo.getAsientosDisponibles());
		v.setAsientosOcupados(vuelo.getAsientosOcupados());
		v.setNumero(vuelo.getNumero());
		
		
		return v;
	}
	

}
