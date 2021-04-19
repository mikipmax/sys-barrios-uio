package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.CatalogoAct;

@ApplicationScoped
public class CatalogoActServicioImpl implements CatalogoActServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoAct> listar() {

		return em.createNamedQuery("CatalogoAct.findAll").getResultList();
	}

	@Override

	public void crear(CatalogoAct E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, CatalogoAct E) {

		E.setIdCatAct(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(CatalogoAct.class, id));
		em.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoAct> listarActivos() {
		
		return em.createNamedQuery("CatalogoAct.findActivos").setParameter("estadoCatAct", "1").getResultList();
	}

	@Override
	public CatalogoAct buscar(int id) {
	
		return em.find(CatalogoAct.class,id);
	}

}
