package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pmaxsoft.dto.Acceso;

@ApplicationScoped
public class AccesoServicioImpl implements AccesoServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Acceso> listar() {

		return em.createNamedQuery("Acceso.findAll").getResultList();
	}

	@Override

	public void crear(Acceso E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Acceso E) {
		E.setIdAcceso(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Acceso.class, id));
		em.getTransaction().commit();
	}

	@Override
	public Acceso login(Acceso E) {
		List<Acceso> lista = em.createNamedQuery("Acceso.Login").setParameter("usuario", E.getUsuario())
				.setParameter("password", E.getPassword()).getResultList();
		if (lista.isEmpty()) {
			return null;
		}
		return lista.get(0);

	}

}
