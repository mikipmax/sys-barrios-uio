package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;


import com.pmaxsoft.dto.Proyecto;

@ApplicationScoped
public class ProyectoServicioImpl implements ProyectoServicioI {

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> listar() {

		return em.createNamedQuery("Proyecto.findAll").getResultList();
	}

	@Override

	public void crear(Proyecto E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Proyecto E) {

		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override
	public Proyecto buscar(int id) {

		return em.find(Proyecto.class, id);
	}

}
