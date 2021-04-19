package com.pmaxsoft.managed;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Persona;
import com.pmaxsoft.servicios.PersonaServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named()
public class ManagedPersona extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Persona persona;
	private Persona personaSelect;
	private List<Persona> listaPersona;
	@Inject
	private PersonaServicioI personaServicio;

	@PostConstruct
	public void init() {
		persona = new Persona();
		personaSelect = new Persona();
		listar();

	}
	
	public void listar() {

		try {
			listaPersona = personaServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public void crear() {

		try {
			
			personaServicio.crear(persona);
			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();
			persona = new Persona();
		}

	}

	public void actualizar() {
		System.out.println(personaSelect);
		try {
		
			personaServicio.actualizar(personaSelect.getIdPersona(), personaSelect);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
		} finally {
			personaSelect = new Persona();
			listar();
		}

	}

	public void leerFila(Persona persona) {
		personaSelect = persona;
		System.out.println(personaSelect);
	}

	public void eliminar() {

		try {

			personaServicio.eliminar(personaSelect.getIdPersona());

			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido eliminar:" + e.getMessage());
			System.out.println("fff");
		} finally {

			listar();
			personaSelect = new Persona();
		}

	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Persona getPersonaSelect() {
		return personaSelect;
	}

	public void setPersonaSelect(Persona personaSelect) {
		this.personaSelect = personaSelect;
	}

	public List<Persona> getListaPersona() {
		return listaPersona;
	}

	public void setListaPersona(List<Persona> listaPersona) {
		this.listaPersona = listaPersona;
	}

	public String formatoFecha(Date date) {
        return formatofecha(date);
    }
	
	
	
}
