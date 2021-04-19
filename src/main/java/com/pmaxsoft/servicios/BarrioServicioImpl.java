package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.pmaxsoft.dto.Barrio;

@ApplicationScoped
public class BarrioServicioImpl implements BarrioServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Barrio> listar() {
		
		return em.createNamedQuery("Barrio.findAll").getResultList();
	}

	@Override

	public void crear(Barrio E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Barrio E) {
		// E.setIdBarrio(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Barrio.class, id));
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Barrio> listarActivos() {

		return em.createNamedQuery("Barrio.findActivos").setParameter("estadoBarrio", "1").getResultList();
	}

	@Override
	public Barrio buscar(int id) {

		return em.find(Barrio.class, id);
	}

}
