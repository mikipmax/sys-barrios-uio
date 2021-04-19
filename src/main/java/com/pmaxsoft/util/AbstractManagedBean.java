package com.pmaxsoft.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Named;

public abstract class AbstractManagedBean {

	protected void mensajeInfo(String mensaje) {
		anadirMensaje(mensaje, FacesMessage.SEVERITY_INFO);
	}

	protected void mensajeError(String mensaje) {
		anadirMensaje(mensaje, FacesMessage.SEVERITY_ERROR);
	}

	private void anadirMensaje(String mensaje, Severity severity) {

		FacesMessage mensajeJSF = new FacesMessage();
		mensajeJSF.setSeverity(severity);
		mensajeJSF.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, mensajeJSF);
	}


	/**
	 * Permite ingresar la fecha en la base de datos según el formato de
	 * postgresl(yyyy-MM-dd)
	 * 
	 * @param fechaNac
	 * @return la fecha en el formato de postgresql
	 * @throws ParseException
	 */
	protected Date fecha(Date fechaNac) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = formato.format(fechaNac);
		Date dateFechaNac = formato.parse(fecha);
		return dateFechaNac;
	}

	/**
	 * Permite visualizar en la tabla de presentación en formato yyyy-MM-dd
	 * 
	 * @param fechaNac
	 * @return la fecha en string
	 */
	protected String formatofecha(Date fechaNac) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		String strfechaNac = formato.format(fechaNac);
		return strfechaNac;
	}
}
