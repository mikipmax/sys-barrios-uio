package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.ActEvento;

@ApplicationScoped
public class ActEventoServicioImpl implements ActEventoServicioI {

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<ActEvento> listar() {

		return em.createNamedQuery("ActEvento.findAll").getResultList();
	}

	@Override

	public void crear(ActEvento E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, ActEvento E) {
		E.setIdActEvento(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(ActEvento.class, id));
		em.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActEvento> listarActEvento(int id) {

		return em.createNamedQuery("ActEvento.findActEvento").setParameter("idEvento", id).getResultList();
	}

}
