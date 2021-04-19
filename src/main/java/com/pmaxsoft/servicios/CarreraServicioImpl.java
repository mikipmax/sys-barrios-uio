package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.Carrera;

@ApplicationScoped
public class CarreraServicioImpl implements CarreraServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrera> listar() {

		return em.createNamedQuery("Carrera.findAll").getResultList();
	}

	@Override

	public void crear(Carrera E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Carrera E) {
		E.setIdCarr(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Carrera.class, id));
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrera> listarActivos() {

		return em.createNamedQuery("Carrera.findActivos").setParameter("estadoCarr", "1").getResultList();
	}

	@Override
	public Carrera buscar(int id) {

		return em.find(Carrera.class, id);
	}

}
