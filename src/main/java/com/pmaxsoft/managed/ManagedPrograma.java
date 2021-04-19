package com.pmaxsoft.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.DocPrograma;
import com.pmaxsoft.dto.Docente;
import com.pmaxsoft.dto.Programa;
import com.pmaxsoft.servicios.DocProgramaServicioI;
import com.pmaxsoft.servicios.DocenteServicioI;
import com.pmaxsoft.servicios.ProgramaServicioI;

import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named
public class ManagedPrograma extends AbstractManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Programa programa;
	private Programa programaSelect;

	private boolean checkDocPrograma;

	private List<Programa> listaPrograma;
	private List<Docente> listaDocente;
	private List<Docente> listaDocenteAux;
	private List<DocPrograma> listaDocPrograma;
	private List<Object[]> listaDocProgramaAux;
	@Inject
	private ProgramaServicioI programaServicio;
	@Inject
	private DocProgramaServicioI docProgramaServicio;
	@Inject
	private DocenteServicioI docenteServicio;

	@PostConstruct
	public void init() {
		programa = new Programa();
		programaSelect = new Programa();

		listar();
		listaDocente = docenteServicio.listar();
		listaDocenteAux = new ArrayList<>();
		listaDocPrograma = new ArrayList<>();
		listaDocProgramaAux = new ArrayList<>();
	}

	public void listar() {

		try {
			listaPrograma = programaServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	public void crear() {

		try {
			programaServicio.crear(programa);
			for (Docente doc : listaDocenteAux) {
				DocPrograma docPrograma = new DocPrograma(doc, programa);
				docProgramaServicio.crear(docPrograma);
			}
			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();
			checkDocPrograma = false;
			programa = new Programa();
			listaDocenteAux = new ArrayList<>();
		}

	}

	public void actualizar() {

		try {
			programaServicio.actualizar(programaSelect.getIdPrograma(), programaSelect);
			// Para insertar en docPrograma automaticamente
			for (DocPrograma docPrograma : listaDocPrograma) {
				docProgramaServicio.eliminar(docPrograma.getIdDocPrograma());
			}

			for (Docente docent : listaDocenteAux) {
				docProgramaServicio.crear(new DocPrograma(docent, programaSelect));
			}

			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
		} finally {
			programaSelect = new Programa();
			listar();

			listaDocenteAux = new ArrayList<>();
		}

	}

	/**
	 * Limpio el check para la seleccion de docentes
	 */
	public void limpiarCheck() {

		checkDocPrograma = false;

		// es importante limpiar esta lista, solución a bugs cuando cierran modal sin
		// editar nada

		listaDocenteAux = new ArrayList<>();

	}

	public void leerFila(Programa programa) {
		listaDocProgramaAux = new ArrayList<>();
		listaDocenteAux = new ArrayList<>();
		programaSelect = programa;
		listaDocPrograma = docProgramaServicio.listarDocPrograma(programaSelect.getIdPrograma());
		// **********************Aquí asocio el docente con su respectivo valor del
		// check******************************
		int i = 0;
		for (Docente docente : listaDocente) {

			Object docProgramaArray[] = { docente, false };
			listaDocProgramaAux.add(docProgramaArray);

			for (DocPrograma docPrograma : listaDocPrograma) {

				if (docente.getIdPersona() == docPrograma.getIdDocente().getIdPersona()) {

					listaDocProgramaAux.get(i)[1] = true;
				}

			}

			i++;
		}
		// Guardo en listaEstudianteAux solo los docentes que estan activos en una
		// determinada docPrograma

		for (Object[] object : listaDocProgramaAux) {
			if ((boolean) object[1]) { // object[1] son valores booleanos asociados a los docentes que estan activos
										// en un doc_event
				listaDocenteAux.add((Docente) object[0]);
			}

		}

	}

	/**
	 * Este método es para saber los docentes que se desea editar y así aniadirlos a
	 * una lista temporal para su posterior persistencia
	 * 
	 * @param docente
	 */
	public void leerFila(Docente docente) {

		if (checkDocPrograma) {

			listaDocenteAux.add(docente);

		} else {
			listaDocenteAux.remove(docente);
		}

	}

	/**
	 * Este metodo me permite saber los docentes que van a hacer editados (agregados
	 * o quitados) de un evento Reacciona cada que doy check o uncheck.
	 * 
	 * @param o, el cual es un array de dos elementos, el primer elemento es un
	 *           Docente y el segundo un booleano
	 * 
	 */
	public void LeerFilaObjetoDocente(Object[] o) {
		// Agrego los docentes que estan habilitados para vinculacion
		if ((boolean) o[1]) {

			// Comparto si ese docente no ha sido ya agregado anteriormente para evitar
			// duplicados
			if (!listaDocenteAux.contains(((Docente) o[0]))) {
				listaDocenteAux.add((Docente) o[0]);
			}
			// Aqui remuevo un docente de su respectivo evento, todo esto en memoria
		} else {

			listaDocenteAux.remove((Docente) o[0]);

		}

	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Programa getProgramaSelect() {
		return programaSelect;
	}

	public void setProgramaSelect(Programa programaSelect) {
		this.programaSelect = programaSelect;
	}

	public List<Programa> getListaPrograma() {
		return listaPrograma;
	}

	public void setListaPrograma(List<Programa> listaPrograma) {
		this.listaPrograma = listaPrograma;
	}

	public boolean isCheckDocPrograma() {
		return checkDocPrograma;
	}

	public void setCheckDocPrograma(boolean checkDocPrograma) {
		this.checkDocPrograma = checkDocPrograma;
	}

	public List<Docente> getListaDocente() {
		return listaDocente;
	}

	public void setListaDocente(List<Docente> listaDocente) {
		this.listaDocente = listaDocente;
	}

	public List<Docente> getListaDocenteAux() {
		return listaDocenteAux;
	}

	public void setListaDocenteAux(List<Docente> listaDocenteAux) {
		this.listaDocenteAux = listaDocenteAux;
	}

	public List<DocPrograma> getListaDocPrograma() {
		return listaDocPrograma;
	}

	public void setListaDocPrograma(List<DocPrograma> listaDocPrograma) {
		this.listaDocPrograma = listaDocPrograma;
	}

	public List<Object[]> getListaDocProgramaAux() {
		return listaDocProgramaAux;
	}

	public void setListaDocProgramaAux(List<Object[]> listaDocProgramaAux) {
		this.listaDocProgramaAux = listaDocProgramaAux;
	}

}
