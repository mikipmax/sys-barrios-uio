package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.Docente;
import com.pmaxsoft.dto.Persona;

@ApplicationScoped
public class DocenteServicioImpl implements DocenteServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Docente> listar() {

		return em.createNamedQuery("Docente.findAll").getResultList();
	}

	@Override

	public void crear(Docente E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Docente E) {
		E.setIdPersona(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Docente.class, id));
		em.getTransaction().commit();

	}

	@Override
	public Docente buscar(int id) {

		return em.find(Docente.class, id);
	}

}
