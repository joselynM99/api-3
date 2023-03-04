package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Avion;

@Repository
@Transactional
public class AvionRepositoryImpl implements IAvionRepositoryImpl{
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Avion buscarPorNombre(String nombre) {
		TypedQuery<Avion> myQuery = this.entityManager.createQuery(
				"SELECT a FROM Avion a WHERE a.nombre=:nombre",
				Avion.class);

		myQuery.setParameter("nombre", nombre);

		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {

			return null;
		}
	}

}
