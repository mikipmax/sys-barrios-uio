package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.Revista;

@ApplicationScoped
public class RevistaServicioImpl implements RevistaServicioI {

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Revista> listar() {

		return em.createNamedQuery("Revista.findAll").getResultList();
	}

	@Override

	public void crear(Revista E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Revista E) {
		E.setIdRevista(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Revista.class, id));
		em.getTransaction().commit();

	}

}
