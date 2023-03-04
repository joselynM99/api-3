package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Vuelo;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, LocalDate fechaVuelo) {
		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(
				"SELECT v FROM Vuelo v WHERE v.origen=:origen AND v.destino=:destino AND v.fechaVuelo=:fechaVuelo AND v.estado='D'",
				Vuelo.class);

		myQuery.setParameter("origen", origen);
		myQuery.setParameter("destino", destino);
		myQuery.setParameter("fechaVuelo", fechaVuelo);

		try {
			return myQuery.getResultList();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Vuelo buscarPorNumero(String numero) {
		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(
				"SELECT v FROM Vuelo v WHERE v.numero=:numero AND v.estado='D'",
				Vuelo.class);

		myQuery.setParameter("numero", numero);

		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public void actualizar(Vuelo vuelo) {
		this.entityManager.merge(vuelo);
	}

}
