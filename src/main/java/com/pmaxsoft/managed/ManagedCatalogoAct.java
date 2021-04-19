package com.pmaxsoft.managed;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.CatalogoAct;
import com.pmaxsoft.servicios.CatalogoActServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named()
public class ManagedCatalogoAct extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private CatalogoAct catalogoAct;
	private CatalogoAct catalogoActSelect;
	private List<CatalogoAct> listaCatalogoAct;
	@Inject
	private CatalogoActServicioI catalogoServicio;

	@PostConstruct
	public void init() {
		catalogoAct = new CatalogoAct();
		catalogoActSelect = new CatalogoAct();
		listar();

	}

	public void listar() {

		try {
			listaCatalogoAct = catalogoServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public void crear() {

		try {
			catalogoServicio.crear(catalogoAct);
			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();
			catalogoAct = new CatalogoAct();
		}

	}

	public void actualizar() {
		System.out.println(catalogoActSelect);
		try {
			catalogoServicio.actualizar(catalogoActSelect.getIdCatAct(), catalogoActSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
		} finally {
			catalogoActSelect = new CatalogoAct();
			listar();
		}

	}

	public void leerFila(CatalogoAct parroquia) {
		catalogoActSelect = parroquia;
		System.out.println(catalogoActSelect);
	}

	public void eliminar() {

		try {

			catalogoServicio.eliminar(catalogoActSelect.getIdCatAct());

			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido eliminar:" + e.getMessage());
			System.out.println("fff");
		} finally {

			listar();
			catalogoActSelect = new CatalogoAct();
		}

	}

	public CatalogoAct getCatalogoAct() {
		return catalogoAct;
	}

	public void setCatalogoAct(CatalogoAct catalogoAct) {
		this.catalogoAct = catalogoAct;
	}

	public CatalogoAct getCatalogoActSelect() {
		return catalogoActSelect;
	}

	public void setCatalogoActSelect(CatalogoAct catalogoActSelect) {
		this.catalogoActSelect = catalogoActSelect;
	}

	public List<CatalogoAct> getListaCatalogoAct() {
		return listaCatalogoAct;
	}

	public void setListaCatalogoAct(List<CatalogoAct> listaCatalogoAct) {
		this.listaCatalogoAct = listaCatalogoAct;
	}

}
