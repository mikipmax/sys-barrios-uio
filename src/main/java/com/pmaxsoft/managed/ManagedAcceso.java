package com.pmaxsoft.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Acceso;
import com.pmaxsoft.dto.Carrera;
import com.pmaxsoft.servicios.AccesoServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@SessionScoped
@Named()
public class ManagedAcceso extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Acceso acceso;
	private Acceso accesoAux;
	private Acceso accesoSelect;
	private List<Acceso> listaAcceso;
	private List<Acceso> listaRol;
	@Inject
	private AccesoServicioI accesoServicio;

	@PostConstruct
	public void init() {
		acceso = new Acceso();
		accesoAux = new Acceso();

		accesoSelect = new Acceso();
		listar();
		listarRol();
	}

	public void listarRol() {
		listaRol = new ArrayList<>();
		listaRol.add(new Acceso((short) 1));
		listaRol.add(new Acceso((short) 2));
	}

	public void listar() {

		try {

			listaAcceso = accesoServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public void crear() {

		try {

			accesoServicio.crear(accesoAux);

			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());

		} finally {

			listar();

			accesoAux = new Acceso();

		}

	}

	public void actualizar() {

		try {
			accesoSelect.setRol(accesoAux.getRol());
			accesoServicio.actualizar(accesoSelect.getIdAcceso(), accesoSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());

		} finally {
			accesoSelect = new Acceso();

			listar();
		}

	}

	public void leerFila(Acceso acceso) {
		accesoSelect = acceso;
		System.out.println(acceso.getRol());
		accesoAux.setRol(acceso.getRol());

	}

	public void eliminar(Acceso acceso) {

		try {

			accesoServicio.eliminar(acceso.getIdAcceso());

			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido eliminar:" + e.getMessage());

		} finally {

			accesoAux = new Acceso();
			listar();
		}

	}

	public String login() {
		String redireccion = null;
		try {

			Acceso permitido = accesoServicio.login(acceso);
			if (permitido != null) {
				System.out.println(acceso.getRol());
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", permitido);
				switch (permitido.getRol()) {
				case 1:
					redireccion = "/evento?faces-redirect=true";
					break;
				case 2:
					redireccion = "/estudiante-admin?faces-redirect=true";
					break;

				}

			} else {
				acceso = new Acceso();
				// redireccion = "/publico-barrio?faces-redirect=true";
				mensajeError("Credenciales Incorrectas");
			}
		} catch (Exception e) {
			mensajeError(e.getMessage());
		}
		return redireccion;

	}

	public Acceso getAcceso() {
		return acceso;
	}

	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}

	public Acceso getAccesoSelect() {
		return accesoSelect;
	}

	public void setAccesoSelect(Acceso accesoSelect) {
		this.accesoSelect = accesoSelect;
	}

	public List<Acceso> getListaAcceso() {
		return listaAcceso;
	}

	public void setListaAcceso(List<Acceso> listaAcceso) {
		this.listaAcceso = listaAcceso;
	}

	public Acceso getAccesoAux() {
		return accesoAux;
	}

	public void setAccesoAux(Acceso accesoAux) {
		this.accesoAux = accesoAux;
	}

	public List<Acceso> getListaRol() {
		return listaRol;
	}

	public void setListaRol(List<Acceso> listaRol) {
		this.listaRol = listaRol;
	}

}
