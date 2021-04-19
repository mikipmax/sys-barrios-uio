package com.pmaxsoft.managed;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Dirigente;

import com.pmaxsoft.dto.Barrio;
import com.pmaxsoft.dto.Cargo;
import com.pmaxsoft.servicios.DirigenteServicioI;

import com.pmaxsoft.servicios.BarrioServicioI;
import com.pmaxsoft.servicios.CargoServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named()
public class ManagedDirigente extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Dirigente dirigente;
	private Barrio barrio;
	private Cargo cargo;
	private Dirigente dirigenteSelect;
	private List<Dirigente> listaDirigente;
	private List<Barrio> listaBarrio;
	private List<Cargo> listaCargo;

	@Inject
	private DirigenteServicioI dirigenteServicio;
	@Inject
	private BarrioServicioI barrioServicio;
	@Inject
	private CargoServicioI cargoServicio;

	@PostConstruct
	public void init() {
		dirigente = new Dirigente();

		barrio = new Barrio();
		cargo = new Cargo();

		dirigenteSelect = new Dirigente();

		listar();
		listaBarrio = barrioServicio.listar();
		listaCargo = cargoServicio.listar();
	}

	public void listar() {

		try {

			listaDirigente = dirigenteServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public String buscar(Barrio barrio) {
		return barrioServicio.buscar(barrio.getIdBarrio()).getNombreBarrio();
	}

	public String buscar(Cargo cargo) {
		return cargoServicio.buscar(cargo.getIdCargo()).getNombreCargo();
	}

	public void crear() {

		try {
			dirigente.setIdCargo(cargo);
			dirigente.setIdBarrio(barrio);
			dirigenteServicio.crear(dirigente);

			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();

			dirigente = new Dirigente();
			barrio = new Barrio();
			cargo = new Cargo();

		}

	}

	public void actualizar() {

		try {
			dirigenteSelect.setIdCargo(cargo);
			dirigenteSelect.setIdBarrio(barrio);

			dirigenteServicio.actualizar(dirigenteSelect.getIdPersona(), dirigenteSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			dirigenteSelect = new Dirigente();
			barrio = new Barrio();
			cargo = new Cargo();
			listar();
		}

	}

	public void leerFila(Dirigente docente) {
		dirigenteSelect = docente;
		barrio.setIdBarrio(docente.getIdBarrio().getIdBarrio());
		cargo.setIdCargo(docente.getIdCargo().getIdCargo());

	}

	public void eliminar() {

		try {

			dirigenteServicio.eliminar(dirigenteSelect.getIdPersona());

			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido eliminar:" + e.getMessage());
			System.out.println("fff");
		} finally {

			listar();
			dirigenteSelect = new Dirigente();
		}

	}

	public String formatoFecha(Date date) {
		return formatofecha(date);
	}

	public Date convertFecha(Date date) throws ParseException {
		return fecha(date);
	}

	public Dirigente getDirigente() {
		return dirigente;
	}

	public void setDirigente(Dirigente dirigente) {
		this.dirigente = dirigente;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public Dirigente getDirigenteSelect() {
		return dirigenteSelect;
	}

	public void setDirigenteSelect(Dirigente dirigenteSelect) {
		this.dirigenteSelect = dirigenteSelect;
	}

	public List<Dirigente> getListaDirigente() {
		return listaDirigente;
	}

	public void setListaDirigente(List<Dirigente> listaDirigente) {
		this.listaDirigente = listaDirigente;
	}

	public List<Barrio> getListaBarrio() {
		return listaBarrio;
	}

	public void setListaBarrio(List<Barrio> listaBarrio) {
		this.listaBarrio = listaBarrio;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getListaCargo() {
		return listaCargo;
	}

	public void setListaCargo(List<Cargo> listaCargo) {
		this.listaCargo = listaCargo;
	}

}
