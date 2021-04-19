package com.pmaxsoft.managed;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Carrera;
import com.pmaxsoft.dto.Docente;
import com.pmaxsoft.servicios.CarreraServicioI;
import com.pmaxsoft.servicios.DocenteServicioI;

import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named()
public class ManagedDocente extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Docente docente;
	private Carrera carrera;

	private Docente docenteSelect;
	private List<Docente> listaDocente;
	private List<Carrera> listaCarrera;

	@Inject
	private DocenteServicioI docenteServicio;
	@Inject
	private CarreraServicioI carreraServicio;

	@PostConstruct
	public void init() {
		docente = new Docente();

		carrera = new Carrera();
		docenteSelect = new Docente();

		listar();
		listaCarrera = carreraServicio.listar();

	}

	public void listar() {

		try {

			listaDocente = docenteServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public String buscar(Carrera carrera) {
		return carreraServicio.buscar(carrera.getIdCarr()).getNombreCarr();
	}

	public void crear() {

		try {

			docente.setIdCarr(carrera);
			docenteServicio.crear(docente);

			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();

			docente = new Docente();
			carrera = new Carrera();

		}

	}

	public void actualizar() {

		try {

			docenteSelect.setIdCarr(carrera);

			docenteServicio.actualizar(docenteSelect.getIdPersona(), docenteSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			docenteSelect = new Docente();
			carrera = new Carrera();
			listar();
		}

	}

	public void leerFila(Docente docente) {
		docenteSelect = docente;
		carrera.setIdCarr(docente.getIdCarr().getIdCarr());

	}

	public void eliminar() {

		try {

			docenteServicio.eliminar(docenteSelect.getIdPersona());

			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido eliminar:" + e.getMessage());
			System.out.println("fff");
		} finally {

			listar();
			docenteSelect = new Docente();
		}

	}

	public String formatoFecha(Date date) {
		return formatofecha(date);
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Docente getDocenteSelect() {
		return docenteSelect;
	}

	public void setDocenteSelect(Docente docenteSelect) {
		this.docenteSelect = docenteSelect;
	}

	public List<Docente> getListaDocente() {
		return listaDocente;
	}

	public void setListaDocente(List<Docente> listaDocente) {
		this.listaDocente = listaDocente;
	}

	public List<Carrera> getListaCarrera() {
		return listaCarrera;
	}

	public void setListaCarrera(List<Carrera> listaCarrera) {
		this.listaCarrera = listaCarrera;
	}

	
	
	
}
