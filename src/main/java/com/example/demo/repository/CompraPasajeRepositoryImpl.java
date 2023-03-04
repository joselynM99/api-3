package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.CompraPasaje;
import com.example.demo.modelo.Vuelo;

@Repository
@Transactional
public class CompraPasajeRepositoryImpl implements ICompraPasajeRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CompraPasaje compra) {
		this.entityManager.persist(compra);
		
	}
	
	
	@Override
	public void actualizar(CompraPasaje compra) {
		this.entityManager.merge(compra);
	}
	
	@Override
	public CompraPasaje buscarPorNumero(String numero) {
		TypedQuery<CompraPasaje> myQuery = this.entityManager.createQuery(
				"SELECT c FROM CompraPasaje c WHERE c.numero=:numero",
				CompraPasaje.class);

		myQuery.setParameter("numero", numero);

		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {

			return null;
		}
	}

}
