package com.pmaxsoft.managed;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Parroquia;
import com.pmaxsoft.servicios.ParroquiaServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named()
public class ManagedParroquia extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Parroquia parroquia;
	private Parroquia parroquiaSelect;
	private List<Parroquia> listaParroquia;
	@Inject
	private ParroquiaServicioI parroquiaServicio;

	@PostConstruct
	public void init() {
		parroquia = new Parroquia();
		parroquiaSelect = new Parroquia();
		listar();

	}

	public void listar() {

		try {
			listaParroquia = parroquiaServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public void crear() {

		try {
			parroquiaServicio.crear(parroquia);
			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();
			parroquia = new Parroquia();
		}

	}

	public void actualizar() {
		System.out.println(parroquiaSelect);
		try {
			parroquiaServicio.actualizar(parroquiaSelect.getIdParr(), parroquiaSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
		} finally {
			parroquiaSelect = new Parroquia();
			listar();
		}

	}

	public void leerFila(Parroquia parroquia) {
		parroquiaSelect = parroquia;
		System.out.println(parroquiaSelect);
	}

	public void eliminar() {

		try {

			parroquiaServicio.eliminar(parroquiaSelect.getIdParr());

			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido eliminar:" + e.getMessage());
			System.out.println("fff");
		} finally {

			listar();
			parroquiaSelect = new Parroquia();
		}

	}

	public Parroquia getParroquia() {
		return parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	public List<Parroquia> getListaParroquia() {
		return listaParroquia;
	}

	public void setListaParroquia(List<Parroquia> listaParroquia) {
		this.listaParroquia = listaParroquia;
	}

	public Parroquia getParroquiaSelect() {
		return parroquiaSelect;
	}

	public void setParroquiaSelect(Parroquia parroquiaSelect) {
		this.parroquiaSelect = parroquiaSelect;
	}

}
