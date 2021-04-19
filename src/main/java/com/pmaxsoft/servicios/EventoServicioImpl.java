package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.Evento;

@ApplicationScoped
public class EventoServicioImpl implements EventoServicioI {
	
	@Inject //quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> listar() {

		return em.createNamedQuery("Evento.findAll").getResultList();
	}

	@Override
	
	public void crear(Evento E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override
	
	public void actualizar(int id, Evento E) {
		E.setIdEvento(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override
	
	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Evento.class, id));
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> listarActivos() {
		
		return em.createNamedQuery("Evento.findActivos").setParameter("estadoEvento", "1").getResultList();
	}

}
