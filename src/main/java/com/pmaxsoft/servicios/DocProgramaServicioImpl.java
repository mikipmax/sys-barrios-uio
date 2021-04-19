package com.pmaxsoft.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.pmaxsoft.dto.DocPrograma;

@ApplicationScoped
public class DocProgramaServicioImpl implements DocProgramaServicioI {

	@Inject // quitar el unitName para usarlo en wildfly
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DocPrograma> listar() {

		return em.createNamedQuery("DocPrograma.findAll").getResultList();
	}

	@Override

	public void crear(DocPrograma E) {
		em.getTransaction().begin();
		em.persist(E);
		em.getTransaction().commit();
	}

	@Override

	public void actualizar(int id, DocPrograma E) {
		E.setIdDocPrograma(id);
		em.getTransaction().begin();
		em.merge(E);
		em.getTransaction().commit();
	}

	@Override

	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(em.find(DocPrograma.class, id));
		em.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocPrograma> listarDocPrograma(int id) {

		return em.createNamedQuery("DocPrograma.findDocPrograma").setParameter("idPrograma", id).getResultList();
	}

}
