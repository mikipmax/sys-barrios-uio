package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.TipoAct;

@ApplicationScoped
public class TipoActServicioImpl implements TipoActServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoAct> listar() {

		return em.createNamedQuery("TipoAct.findAll").getResultList();
	}

	@Override

	public void crear(TipoAct E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, TipoAct E) {

		E.setIdTipoAct(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(TipoAct.class, id));
		em.getTransaction().commit();

	}

}
