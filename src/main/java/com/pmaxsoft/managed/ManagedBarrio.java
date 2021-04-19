package com.pmaxsoft.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Barrio;
import com.pmaxsoft.dto.Parroquia;
import com.pmaxsoft.servicios.BarrioServicioI;
import com.pmaxsoft.servicios.ParroquiaServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named()
public class ManagedBarrio extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Barrio barrio;
	private Parroquia parroquia;

	private Barrio barrioSelect;
	private List<Barrio> listaBarrio;
	private List<Parroquia> listaParroquia;
	@Inject
	private BarrioServicioI barrioServicio;
	@Inject
	ParroquiaServicioI parroquiaServicio;

	@PostConstruct
	public void init() {
		barrio = new Barrio();
		parroquia = new Parroquia();
		barrioSelect = new Barrio();

		listar();
		listaParroquia = parroquiaServicio.listar();
	}

	public void listar() {

		try {

			listaBarrio = barrioServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public String buscar(Parroquia parroquia) {
		return parroquiaServicio.buscar(parroquia.getIdParr()).getNombreParr();
	}

	public void crear() {

		try {
			System.out.println(parroquia.getNombreParr());
		
				barrio.setIdParr(parroquia);
			
		
			barrioServicio.crear(barrio);

			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();

			barrio = new Barrio();
			parroquia = new Parroquia();

		}

	}

	public void actualizar() {

		try {

			barrioSelect.setIdParr(parroquia);

			barrioServicio.actualizar(barrioSelect.getIdBarrio(), barrioSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			barrioSelect = new Barrio();
			parroquia = new Parroquia();
			listar();
		}

	}

	public void leerFila(Barrio barrio) {
		barrioSelect = barrio;
		parroquia.setIdParr(barrio.getIdParr().getIdParr());

	}

	public void eliminar() {

		try {

			barrioServicio.eliminar(barrioSelect.getIdBarrio());

			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido eliminar:" + e.getMessage());
			System.out.println("fff");
		} finally {

			listar();
			barrioSelect = new Barrio();
		}

	}

	public String formatoFecha(Date date) {
		return formatofecha(date);
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public Barrio getBarrioSelect() {
		return barrioSelect;
	}

	public void setBarrioSelect(Barrio barrioSelect) {
		this.barrioSelect = barrioSelect;
	}

	public List<Barrio> getListaBarrio() {
		return listaBarrio;
	}

	public void setListaBarrio(List<Barrio> listaBarrio) {
		this.listaBarrio = listaBarrio;
	}

	public List<Parroquia> getListaParroquia() {
		return listaParroquia;
	}

	public void setListaParroquia(List<Parroquia> listaParroquia) {
		this.listaParroquia = listaParroquia;
	}

	public Parroquia getParroquia() {
		return parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

}
