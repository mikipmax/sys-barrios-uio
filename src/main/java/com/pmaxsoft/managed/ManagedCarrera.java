package com.pmaxsoft.managed;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Carrera;

import com.pmaxsoft.servicios.CarreraServicioI;

import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named()
public class ManagedCarrera extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Carrera carrera;

	
	private Carrera carreraSelect;
	private List<Carrera> listaCarrera;

	@Inject
	private CarreraServicioI carreraServicio;


	@PostConstruct
	public void init() {
		carrera = new Carrera();

		carreraSelect = new Carrera();
		
		listar();
	
	}

	public void listar() {

		try {

			listaCarrera = carreraServicio.listar();

		} catch (Exception e) {
			mensajeError("Error: " + e.getMessage());
		}

	}



	public void crear() {

		try {

		
			carreraServicio.crear(carrera);

			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();

			carrera = new Carrera();
		

		}

	}

	public void actualizar() {

		try {
			
		
			
			carreraServicio.actualizar(carreraSelect.getIdCarr(), carreraSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			carreraSelect = new Carrera();
		
			listar();
		}

	}

	public void leerFila(Carrera carrera) {
		carreraSelect = carrera;
		
	
	}

	public void eliminar() {

		try {

			carreraServicio.eliminar(carreraSelect.getIdCarr());

			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido eliminar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();
			carreraSelect = new Carrera();
		}

	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Carrera getCarreraSelect() {
		return carreraSelect;
	}

	public void setCarreraSelect(Carrera carreraSelect) {
		this.carreraSelect = carreraSelect;
	}

	public List<Carrera> getListaCarrera() {
		return listaCarrera;
	}

	public void setListaCarrera(List<Carrera> listaCarrera) {
		this.listaCarrera = listaCarrera;
	}

	



}
