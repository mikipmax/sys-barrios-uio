package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.Persona;

@ApplicationScoped
public class PersonaServicioImpl implements PersonaServicioI {
	// Dejamos que nos gestione el servidor de aplicaciones
	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listar() {

		return em.createNamedQuery("Persona.findAll").getResultList();
	}

	@Override

	public void crear(Persona per) {
		em.getTransaction().begin();
		em.persist(per);
		em.getTransaction().commit();

	}

	@Override

	public void actualizar(int id, Persona per) {
		per.setIdPersona(id);
		em.getTransaction().begin();
		em.merge(per);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Persona.class, id));
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listarActivos() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Persona.findAactivos").setParameter("estadoPersona", "1").getResultList();
	}

}
