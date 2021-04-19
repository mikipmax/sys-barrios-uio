package com.pmaxsoft.managed;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Proyecto;
import com.pmaxsoft.dto.Programa;

import com.pmaxsoft.servicios.ProgramaServicioI;
import com.pmaxsoft.servicios.ProyectoServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named()
public class ManagedProyecto extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Proyecto proyecto;
	private Proyecto proyectoSelect;
	private Programa programa;

	private List<Proyecto> listaProyecto;
	private List<Programa> listaPrograma;
	@Inject
	private ProyectoServicioI proyectoServicio;
	@Inject
	private ProgramaServicioI programaServicio;

	@PostConstruct
	public void init() {
		proyecto = new Proyecto();
		programa = new Programa();
		proyectoSelect = new Proyecto();

		listar();
		listaPrograma = programaServicio.listar();
	}

	public void listar() {

		try {

			listaProyecto = proyectoServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public String buscar(Programa programa) {
		return programaServicio.buscar(programa.getIdPrograma()).getNombrePrograma();
	}

	public void crear() {

		try {

			proyecto.setIdPrograma(programa);

			proyectoServicio.crear(proyecto);

			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());

		} finally {

			listar();

			proyecto = new Proyecto();
			programa = new Programa();

		}

	}

	public void actualizar() {

		try {

			proyectoSelect.setIdPrograma(programa);

			proyectoServicio.actualizar(proyectoSelect.getIdProyecto(), proyectoSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			proyectoSelect = new Proyecto();
			programa = new Programa();
			listar();
		}

	}

	public void leerFila(Proyecto proyecto) {
		proyectoSelect = proyecto;
		programa.setIdPrograma(proyecto.getIdPrograma().getIdPrograma());

	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Proyecto getProyectoSelect() {
		return proyectoSelect;
	}

	public void setProyectoSelect(Proyecto proyectoSelect) {
		this.proyectoSelect = proyectoSelect;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public List<Proyecto> getListaProyecto() {
		return listaProyecto;
	}

	public void setListaProyecto(List<Proyecto> listaProyecto) {
		this.listaProyecto = listaProyecto;
	}

	public List<Programa> getListaPrograma() {
		return listaPrograma;
	}

	public void setListaPrograma(List<Programa> listaPrograma) {
		this.listaPrograma = listaPrograma;
	}

}
