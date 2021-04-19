package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.Estudiante;
import com.pmaxsoft.dto.Persona;

@ApplicationScoped
public class EstudianteServicioImpl implements EstudianteServicioI {

	@Inject //quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> listar() {

		return em.createNamedQuery("Estudiante.findAll").getResultList();
	}

	@Override

	public void crear(Estudiante E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override
	
	public void actualizar(int id, Estudiante E) {
		
		E.setIdPersona(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override
	
	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Estudiante.class, id));
		em.getTransaction().commit();
	}

}
