package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Cliente buscarPorCedula(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:cedula",
				Cliente.class);

		myQuery.setParameter("cedula", cedula);

		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {

			return null;
		}
	}

}
