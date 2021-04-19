package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.pmaxsoft.dto.Cargo;

@ApplicationScoped
public class CargoServicioImpl implements CargoServicioI {
	
	@Inject //quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> listar() {

		return em.createNamedQuery("Cargo.findAll").getResultList();
	}

	@Override

	public void crear(Cargo E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Cargo E) {
		E.setIdCargo(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Cargo.class, id));
		em.getTransaction().commit();

	}

	@Override
	public Cargo buscar(int id) {
		
		return em.find(Cargo.class,id);
	}

}
