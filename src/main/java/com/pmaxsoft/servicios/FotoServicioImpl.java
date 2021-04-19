package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.pmaxsoft.dto.Foto;

@ApplicationScoped
public class FotoServicioImpl implements FotoServicioI {

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Foto> listar() {

		return em.createNamedQuery("Foto.findAll").getResultList();
	}

	@Override

	public void crear(Foto E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, Foto E) {
		E.setIdFoto(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Foto.class, id));
		em.getTransaction().commit();
	}

	@Override
	public Foto buscar(int id) {

		return em.find(Foto.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Foto buscarFotoEvento(int id) {
		List<Foto> lista = em.createNamedQuery("Foto.findByEvento").setParameter("idEvento", id).getResultList();
		if (lista.isEmpty()) {
			return null;
		}
		return lista.get(0);
	}

	// Para listar varias fotos por evento (no usado por limitación del servidor)
	@SuppressWarnings("unchecked")
	@Override
	public List<Foto> listaPorEvento(int id) {
		return em.createNamedQuery("Foto.findByEvento").setParameter("idEvento", id).getResultList();
	}

}
