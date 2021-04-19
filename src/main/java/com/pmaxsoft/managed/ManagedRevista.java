package com.pmaxsoft.managed;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Revista;


import com.pmaxsoft.servicios.RevistaServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named
public class ManagedRevista extends AbstractManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Revista revista;
	private Revista revistaSelect;
	private List<Revista> listaRevista;
	@Inject
	private RevistaServicioI revistaServicio;

	@PostConstruct
	public void init() {
		revista = new Revista();
		revistaSelect = new Revista();
		listar();

	}

	public void listar() {

		try {
			listaRevista = revistaServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public void crear() {

		try {
			revistaServicio.crear(revista);
			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();
			revista = new Revista();
		}

	}

	public void actualizar() {
		System.out.println(revistaSelect);
		try {
			revistaServicio.actualizar(revistaSelect.getIdRevista(), revistaSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
		} finally {
			revistaSelect = new Revista();
			listar();
		}

	}

	public void leerFila(Revista revista) {
		revistaSelect = revista;

	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}

	public Revista getRevistaSelect() {
		return revistaSelect;
	}

	public void setRevistaSelect(Revista revistaSelect) {
		this.revistaSelect = revistaSelect;
	}

	public List<Revista> getListaRevista() {
		return listaRevista;
	}

	public void setListaRevista(List<Revista> listaRevista) {
		this.listaRevista = listaRevista;
	}

	

}
