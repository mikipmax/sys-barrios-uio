package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;


import com.pmaxsoft.dto.Programa;

@ApplicationScoped
public class ProgramaServicioImpl implements ProgramaServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Programa> listar() {

		return em.createNamedQuery("Programa.findAll").getResultList();
	}

	@Override

	public void crear(Programa E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Programa E) {
		E.setIdPrograma(id);
		;
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Programa.class, id));
		em.getTransaction().commit();

	}

	@Override
	public Programa buscar(int id) {

		return em.find(Programa.class, id);
	}

}
