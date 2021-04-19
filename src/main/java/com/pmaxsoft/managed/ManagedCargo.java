package com.pmaxsoft.managed;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Cargo;

import com.pmaxsoft.servicios.CargoServicioI;

import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named
public class ManagedCargo extends AbstractManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Cargo cargo;
	private Cargo cargoSelect;
	private List<Cargo> listaCargo;
	@Inject
	private CargoServicioI cargoServicio;

	@PostConstruct
	public void init() {
		cargo = new Cargo();
		cargoSelect = new Cargo();
		listar();

	}

	public void listar() {

		try {
			listaCargo = cargoServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public void crear() {

		try {
			cargoServicio.crear(cargo);
			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();
			cargo = new Cargo();
		}

	}

	public void actualizar() {
		System.out.println(cargoSelect);
		try {
			cargoServicio.actualizar(cargoSelect.getIdCargo(), cargoSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
		} finally {
			cargoSelect = new Cargo();
			listar();
		}

	}

	public void leerFila(Cargo cargo) {
		cargoSelect = cargo;

	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Cargo getCargoSelect() {
		return cargoSelect;
	}

	public void setCargoSelect(Cargo cargoSelect) {
		this.cargoSelect = cargoSelect;
	}

	public List<Cargo> getListaCargo() {
		return listaCargo;
	}

	public void setListaCargo(List<Cargo> listaCargo) {
		this.listaCargo = listaCargo;
	}

}
