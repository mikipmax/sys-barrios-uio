package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.Vinculacion;

@ApplicationScoped
public class VinculacionServicioImpl implements VinculacionServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Vinculacion> listar() {

		return em.createNamedQuery("Vinculacion.findAll").getResultList();
	}

	@Override

	public void crear(Vinculacion E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Vinculacion E) {
		E.setIdVinculacion(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Vinculacion.class, id));
		em.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vinculacion> listarActivos() {

		return em.createNamedQuery("Vinculacion.findActivos").setParameter("estadoVinculacion", "1").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vinculacion> listarEstudiantesVinculacion(int id) {

		return em.createNamedQuery("Vinculacion.findEstudiantesVinculacion").setParameter("idEvento", id)
				.getResultList();
	}

}
