package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.Parroquia;

@ApplicationScoped
public class ParroquiaServicioImpl implements ParroquiaServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Parroquia> listar() {

		return em.createNamedQuery("Parroquia.findAll").getResultList();
	}

	@Override

	public void crear(Parroquia E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Parroquia E) {
		E.setIdParr(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Parroquia.class, id));

		em.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parroquia> listarActivos() {
		//
		return em.createNamedQuery("Parroquia.findActivos").setParameter("estadoParr", "1").getResultList();
	}

	@Override
	public Parroquia buscar(int id) {

		return em.find(Parroquia.class, id);
	}

}
