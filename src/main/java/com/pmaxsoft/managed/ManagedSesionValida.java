package com.pmaxsoft.managed;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.inject.Named;

import com.pmaxsoft.dto.Acceso;

@SessionScoped
@Named()
public class ManagedSesionValida implements Serializable {

	private static final long serialVersionUID = 1L;

	public void verificarSesionAdmin() {
		verificarSesion(1);
	}

	public void verificarSesionEstudiante() {
		verificarSesion(2);
	}

	public void verificarSesion(int rol) {
		try {
			ExternalContext exContext = FacesContext.getCurrentInstance().getExternalContext();
			Acceso acceso = (Acceso) exContext.getSessionMap().get("usuario");
			if (acceso != null) {

				if (acceso.getRol() != rol) {
					exContext.redirect("./login.xhtml");

				}

			} else {
				exContext.redirect("./login.xhtml");
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	public void cerrarSesion() {
		System.out.println("n*-------------");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

}
