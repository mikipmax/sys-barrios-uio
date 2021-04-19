package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.pmaxsoft.dto.DocEvent;

@ApplicationScoped
public class DocEventServicioImpl implements DocEventServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<DocEvent> listar() {

		return em.createNamedQuery("DocEvent.findAll").getResultList();
	}

	@Override

	public void crear(DocEvent E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, DocEvent E) {
		E.setIdDocEvent(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(DocEvent.class, id));
		em.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocEvent> listarDocEvent(int id) {

		return em.createNamedQuery("DocEvent.findDocEvent").setParameter("idEvento", id).getResultList();
	}

}
