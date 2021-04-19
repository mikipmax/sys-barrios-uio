package com.pmaxsoft.managed;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Estudiante;

import com.pmaxsoft.dto.Carrera;
import com.pmaxsoft.servicios.EstudianteServicioI;

import com.pmaxsoft.servicios.CarreraServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named()
public class ManagedEstudiante extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Estudiante estudiante;
	private Carrera carrera;

	private Estudiante estudianteSelect;
	private List<Estudiante> listaEstudiante;
	private List<Carrera> listaCarrera;

	@Inject
	private EstudianteServicioI estudianteServicio;
	@Inject
	private CarreraServicioI carreraServicio;

	@PostConstruct
	public void init() {
		estudiante = new Estudiante();

		carrera = new Carrera();
		estudianteSelect = new Estudiante();

		listar();
		listaCarrera = carreraServicio.listar();

	}

	public void listar() {

		try {

			listaEstudiante = estudianteServicio.listar();
			
		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public String buscar(Carrera carrera) {
		return carreraServicio.buscar(carrera.getIdCarr()).getNombreCarr();
	}

	public void crear() {

		try {

			 estudiante.setIdCarr(carrera);
			estudianteServicio.crear(estudiante);

			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();

			estudiante = new Estudiante();
			carrera = new Carrera();

		}

	}

	public void actualizar() {

		try {

			 estudianteSelect.setIdCarr(carrera);

			estudianteServicio.actualizar(estudianteSelect.getIdPersona(), estudianteSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			estudianteSelect = new Estudiante();
			carrera = new Carrera();
			listar();
		}

	}

	public void leerFila(Estudiante estudiante) {
		estudianteSelect = estudiante;
		carrera.setIdCarr(estudiante.getIdCarr().getIdCarr());

	}

	public void eliminar() {

		try {

			estudianteServicio.eliminar(estudianteSelect.getIdPersona());

			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido eliminar:" + e.getMessage());
			System.out.println("fff");
		} finally {

			listar();
			estudianteSelect = new Estudiante();
		}

	}

	public String formatoFecha(Date date) {
		return formatofecha(date);
	}



	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Estudiante getEstudianteSelect() {
		return estudianteSelect;
	}

	public void setEstudianteSelect(Estudiante estudianteSelect) {
		this.estudianteSelect = estudianteSelect;
	}

	public List<Estudiante> getListaEstudiante() {
		return listaEstudiante;
	}

	public void setListaEstudiante(List<Estudiante> listaEstudiante) {
		this.listaEstudiante = listaEstudiante;
	}

	public List<Carrera> getListaCarrera() {
		return listaCarrera;
	}

	public void setListaCarrera(List<Carrera> listaCarrera) {
		this.listaCarrera = listaCarrera;
	}

}
