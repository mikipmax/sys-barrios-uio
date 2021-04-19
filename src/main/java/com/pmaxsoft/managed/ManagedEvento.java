package com.pmaxsoft.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pmaxsoft.dto.Evento;
import com.pmaxsoft.dto.Proyecto;
import com.pmaxsoft.dto.Vinculacion;
import com.pmaxsoft.dto.ActEvento;
import com.pmaxsoft.dto.Barrio;
import com.pmaxsoft.dto.Carrera;
import com.pmaxsoft.dto.CatalogoAct;
import com.pmaxsoft.dto.DocEvent;
import com.pmaxsoft.dto.Docente;
import com.pmaxsoft.dto.Estudiante;
import com.pmaxsoft.servicios.EventoServicioI;
import com.pmaxsoft.servicios.ProyectoServicioI;
import com.pmaxsoft.servicios.VinculacionServicioI;
import com.pmaxsoft.servicios.ActEventoServicioI;
import com.pmaxsoft.servicios.BarrioServicioI;
import com.pmaxsoft.servicios.CarreraServicioI;
import com.pmaxsoft.servicios.CatalogoActServicioI;
import com.pmaxsoft.servicios.DocEventServicioI;
import com.pmaxsoft.servicios.DocenteServicioI;
import com.pmaxsoft.servicios.EstudianteServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@ViewScoped
@Named()
public class ManagedEvento extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Evento evento;
	private Docente docente;
	private Barrio barrio;
	private Carrera carrera;
	private Estudiante estudiante;
	private Evento eventoSelect;
	private CatalogoAct catalogoAct;
	private Proyecto proyecto;
	private boolean check;
	private boolean checkDocEvent;
	private boolean checkActEvento;
	private List<Evento> listaEvento;
	private List<Docente> listaDocente;
	private List<Docente> listaDocenteAux;
	private List<Barrio> listaBarrio;
	private List<Carrera> listaCarrera;
	private List<Proyecto> listaProyecto;
	private List<CatalogoAct> listaCatalogoAct;
	private List<CatalogoAct> listaCatalogoActAux;
	private List<String> listaEstado;

	private List<Estudiante> listaEstudiante;
	private List<Estudiante> listaEstudianteAux;
	private List<Vinculacion> listaEstudianteVinculacion;
	private List<DocEvent> listaDocEvent;
	private List<ActEvento> listaActEvento;
	private List<Object[]> listaEstudianteVinculacionAux;
	private List<Object[]> listaDocEventAux;
	private List<Object[]> listaActEventoAux;
	@Inject
	private EventoServicioI eventoServicio;
	@Inject
	private DocenteServicioI docenteServicio;
	@Inject
	private BarrioServicioI barrioServicio;
	@Inject
	private CarreraServicioI carreraServicio;
	@Inject
	private CatalogoActServicioI catalogoActServicio;
	@Inject
	private VinculacionServicioI vinculacionServicio;
	@Inject
	private EstudianteServicioI estudianteServicio;
	@Inject
	private DocEventServicioI docEventServicio;
	@Inject
	private ActEventoServicioI actEventoServicio;
	@Inject
	ProyectoServicioI proyectoServicio;

	@PostConstruct
	public void init() {
		evento = new Evento();
		docente = new Docente();
		eventoSelect = new Evento();
		barrio = new Barrio();
		carrera = new Carrera();
		catalogoAct = new CatalogoAct();
		estudiante = new Estudiante();
		proyecto = new Proyecto();
		listar();
		listaDocente = docenteServicio.listar();
		listaProyecto = proyectoServicio.listar();
		listaBarrio = barrioServicio.listar();
		listaCarrera = carreraServicio.listar();
		listaCatalogoAct = catalogoActServicio.listar();
		listaEstudiante = estudianteServicio.listar();
		listaEstudianteAux = new ArrayList<>();
		listaDocenteAux = new ArrayList<>();
		listaCatalogoActAux = new ArrayList<>();
		listaEstudianteVinculacion = new ArrayList<>();
		listaEstudianteVinculacionAux = new ArrayList<>();
		listaDocEvent = new ArrayList<>();
		listaDocEventAux = new ArrayList<>();
		listaActEvento = new ArrayList<>();
		listaActEventoAux = new ArrayList<>();
		listarEstado();
	}

	public void listar() {

		try {

			listaEvento = eventoServicio.listar();

		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}
public void listarEstado() {
	listaEstado=new ArrayList<>();
	listaEstado.add("Culminado");
	listaEstado.add("En proceso");
}
//revisar para borrar
	public String buscarDocente(Docente docente) {
		return docenteServicio.buscar(docente.getIdPersona()).getNombre();
	}

	public String buscarProyecto(Proyecto proyecto) {
		return proyectoServicio.buscar(proyecto.getIdProyecto()).getNombreProyecto();
	}

	public String buscarBarrio(Barrio barrio) {
		return barrioServicio.buscar(barrio.getIdBarrio()).getNombreBarrio();
	}

	public String buscarCarrera(Carrera carrera) {
		return carreraServicio.buscar(carrera.getIdCarr()).getNombreCarr();
	}

	public String buscarCatalogoAct(CatalogoAct catalogoAct) {
		return catalogoActServicio.buscar(catalogoAct.getIdCatAct()).getNombreCatAct();
	}

	public void crear() {

		try {
			evento.setIdProyecto(proyecto);
			evento.setIdBarrio(barrio);
			evento.setIdCarr(carrera);

			eventoServicio.crear(evento);

			for (CatalogoAct catAct : listaCatalogoActAux) {

				ActEvento actEvento = new ActEvento(catAct, evento);
				actEventoServicio.crear(actEvento);

			}
			for (Docente doc : listaDocenteAux) {
				DocEvent docEvent = new DocEvent(doc, evento);
				docEventServicio.crear(docEvent);
			}
			for (Estudiante estud : listaEstudianteAux) {
				Vinculacion vinc = new Vinculacion(estud, evento);
				vinculacionServicio.crear(vinc);
			}
			mensajeInfo("Registro guardado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido guardar:" + e.getMessage());
			e.printStackTrace(System.out);
		} finally {

			listar();
			check = false;
			checkDocEvent = false;
			checkActEvento = false;
			evento = new Evento();
			proyecto = new Proyecto();
			barrio = new Barrio();
			carrera = new Carrera();
			catalogoAct = new CatalogoAct();
			listaEstudianteAux = new ArrayList<>();
			listaDocenteAux = new ArrayList<>();
			listaCatalogoActAux = new ArrayList<>();
		}

	}

	public void actualizar() {

		try {
			eventoSelect.setIdProyecto(proyecto);
			eventoSelect.setIdBarrio(barrio);
			eventoSelect.setIdCarr(carrera);

			eventoServicio.actualizar(eventoSelect.getIdEvento(), eventoSelect);

			// Para insertar en actEvento automaticamente
			for (ActEvento actEvento : listaActEvento) {
				actEventoServicio.eliminar(actEvento.getIdActEvento());
			}

			for (CatalogoAct catAct : listaCatalogoActAux) {
				actEventoServicio.crear(new ActEvento(catAct, eventoSelect));
			}
			// Para insertar en docEvent automaticamente
			for (DocEvent docEvent : listaDocEvent) {
				docEventServicio.eliminar(docEvent.getIdDocEvent());
			}

			for (Docente docent : listaDocenteAux) {
				docEventServicio.crear(new DocEvent(docent, eventoSelect));
			}

			// Para insertar en vinculación automaticamente
			for (Vinculacion vinculacion : listaEstudianteVinculacion) {
				vinculacionServicio.eliminar(vinculacion.getIdVinculacion());
			}

			for (Estudiante student : listaEstudianteAux) {
				vinculacionServicio.crear(new Vinculacion(student, eventoSelect));
			}
			mensajeInfo("Registro actualizado correctamente");

		} catch (Exception e) {
			mensajeError("No sé ha podido actualizar:" + e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			eventoSelect = new Evento();
			docente = new Docente();
			proyecto = new Proyecto();
			barrio = new Barrio();
			carrera = new Carrera();
			catalogoAct = new CatalogoAct();
			listar();
			listaEstudianteAux = new ArrayList<>();
			listaDocenteAux = new ArrayList<>();
			listaCatalogoActAux = new ArrayList<>();
		}

	}

	/**
	 * Limpio el check para la seleccion de estudiantes y docentes
	 */
	public void limpiarCheck() {

		check = false;
		checkDocEvent = false;
		checkActEvento = false;
		// es importante limpiar estas listas, solución a bugs cuando cierran modal sin
		// editar nada
		listaEstudianteAux = new ArrayList<>();
		listaDocenteAux = new ArrayList<>();
		listaCatalogoActAux = new ArrayList<>();
	}

	/**
	 * Permite saber el evento que se selecciono con todos sus propiedades
	 * Adicionalmente traemos los estudiantes, docentes y ... que selecciono en el
	 * datatable
	 * 
	 * @param evento
	 */
	public void leerFila(Evento evento) {
		listaEstudianteVinculacionAux = new ArrayList<>();
		listaDocEventAux = new ArrayList<>();
		listaActEventoAux = new ArrayList<>();
		listaEstudianteAux = new ArrayList<>();
		listaDocenteAux = new ArrayList<>();
		listaCatalogoActAux = new ArrayList<>();
		eventoSelect = evento;
		
		proyecto.setIdProyecto(evento.getIdProyecto().getIdProyecto());
		barrio.setIdBarrio(evento.getIdBarrio().getIdBarrio());
		carrera.setIdCarr(evento.getIdCarr().getIdCarr());

		listaEstudianteVinculacion = vinculacionServicio.listarEstudiantesVinculacion(eventoSelect.getIdEvento());
		listaDocEvent = docEventServicio.listarDocEvent(eventoSelect.getIdEvento());
		listaActEvento = actEventoServicio.listarActEvento(eventoSelect.getIdEvento());
		
		int i = 0;// para el indice de la nueva lista de objetos
		// **********************Aquí asocio el estudiante con su respectivo valor del
		// check******************************
		for (Estudiante estudiante : listaEstudiante) {

			Object estudianteVinculacion[] = { estudiante, false };
			listaEstudianteVinculacionAux.add(estudianteVinculacion);

			for (Vinculacion vinculacion : listaEstudianteVinculacion) {

				if (estudiante.getIdPersona() == vinculacion.getIdEstudiante().getIdPersona()) {

					listaEstudianteVinculacionAux.get(i)[1] = true;
				}

			}

			i++;
		}
		// Guardo en listaEstudianteAux solo los estudiantes que estan activos en una
		// determinada vinculacion

		for (Object[] object : listaEstudianteVinculacionAux) {
			if ((boolean) object[1]) { // object[1] son valores booleanos asociados a los estudiantes que estan activos
										// en una vinculacion
				listaEstudianteAux.add((Estudiante) object[0]);
			}

		}

		// **********************Aquí asocio el docente con su respectivo valor del
		// check******************************
		i = 0; // Reseteo
		for (Docente docente : listaDocente) {

			Object docEventArray[] = { docente, false };
			listaDocEventAux.add(docEventArray);

			for (DocEvent docEvent : listaDocEvent) {

				if (docente.getIdPersona() == docEvent.getIdDocente().getIdPersona()) {

					listaDocEventAux.get(i)[1] = true;
				}

			}

			i++;
		}
		// Guardo en listaEstudianteAux solo los docentes que estan activos en una
		// determinada docEvent

		for (Object[] object : listaDocEventAux) {
			if ((boolean) object[1]) { // object[1] son valores booleanos asociados a los docentes que estan activos
										// en un doc_event
				listaDocenteAux.add((Docente) object[0]);
			}

		}

		// **********************Aquí asocio el catalogoAct con su respectivo valor del
		// check******************************
		i = 0; // Reseteo
		for (CatalogoAct catalogoAct : listaCatalogoAct) {

			Object actEventoArray[] = { catalogoAct, false };
			listaActEventoAux.add(actEventoArray);

			for (ActEvento actEvento : listaActEvento) {

				if (catalogoAct.getIdCatAct() == actEvento.getIdCatAct().getIdCatAct()) {

					listaActEventoAux.get(i)[1] = true;
				}

			}

			i++;
		}
		// Guardo en listaCatalogoActAux solo los catalogoAct que estan activos en una
		// determinado ActEvent

		for (Object[] object : listaActEventoAux) {
			if ((boolean) object[1]) { // object[1] son valores booleanos asociados a los catalogAct que estan activos
										// en un act_evento
				listaCatalogoActAux.add((CatalogoAct) object[0]);
			}

		}

	}

	/**
	 * Este método es para saber los estudiantes que se desea editar y así
	 * aniadirlos a una lista temporal para su posterior persistencia
	 * 
	 * @param estudiante
	 */
	public void leerFila(Estudiante estudiante) {

		if (check) {
			listaEstudianteAux.add(estudiante);

		} else {
			listaEstudianteAux.remove(estudiante);
		}

	}

	/**
	 * Este método es para saber los docentes que se desea editar y así aniadirlos a
	 * una lista temporal para su posterior persistencia
	 * 
	 * @param docente
	 */
	public void leerFila(Docente docente) {

		if (checkDocEvent) {
			System.out.println("bool docente");
			listaDocenteAux.add(docente);

		} else {
			listaDocenteAux.remove(docente);
		}

	}

	/**
	 * Este método es para saber los catalogoAct que se desea editar y así
	 * aniadirlos a una lista temporal para su posterior persistencia
	 * 
	 * @param catalogAct
	 */
	public void leerFila(CatalogoAct catalogoAct) {

		if (isCheckActEvento()) {
			listaCatalogoActAux.add(catalogoAct);

		} else {
			listaCatalogoActAux.remove(catalogoAct);
		}

	}

	/**
	 * Este metodo me permite saber los estudiantes que van hacer editados
	 * (agregados o quitados) de la vinculacion Reacciona cada que doy check o
	 * uncheck.
	 * 
	 * @param o, el cual es un array de dos elementos, el primer elemento es un
	 *           Estudiante y el segundo un booleano
	 * 
	 */
	public void LeerFilaObjecto(Object[] o) {
		// Agrego los estudiantes que estan habilitados para vinculacion
		if ((boolean) o[1]) {

			// Comparto si ese estudiante no ha sido ya agregado anteriormente para evitar
			// duplicados
			if (!listaEstudianteAux.contains(((Estudiante) o[0]))) {
				listaEstudianteAux.add((Estudiante) o[0]);
			}
			// Aqui remuevo un estudiante de su respectiva vinculacion, todo esto en memoria
		} else {
			System.out.println("entr");
			listaEstudianteAux.remove((Estudiante) o[0]);

		}

	}

	/**
	 * Este metodo me permite saber los docentes que van hacer editados (agregados o
	 * quitados) de un evento Reacciona cada que doy check o uncheck.
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

	/**
	 * Este metodo me permite saber los catalogoAct que van hacer editados
	 * (agregados o quitados) de un evento Reacciona cada que doy check o uncheck.
	 * 
	 * @param o, el cual es un array de dos elementos, el primer elemento es un
	 *           catalogoAct y el segundo un booleano
	 * 
	 */
	public void LeerFilaObjetoCatalogoAct(Object[] o) {
		// Agrego los catalogoAct que estan habilitados para un actEvento
		if ((boolean) o[1]) {

			// Comparto si ese catalogoAct no ha sido ya agregado anteriormente para evitar
			// duplicados
			if (!listaCatalogoActAux.contains(((CatalogoAct) o[0]))) {
				listaCatalogoActAux.add((CatalogoAct) o[0]);
			}
			// Aqui remuevo un docente de su respectivo evento, todo esto en memoria
		} else {

			listaCatalogoActAux.remove((CatalogoAct) o[0]);

		}

	}

	public void eliminar() {

		try {

			eventoServicio.eliminar(eventoSelect.getIdEvento());

			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("No sé ha podido eliminar:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			listar();
			eventoSelect = new Evento();
		}

	}

	public String formatoFecha(Date date) {
		return formatofecha(date);
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Evento getEventoSelect() {
		return eventoSelect;
	}

	public void setEventoSelect(Evento eventoSelect) {
		this.eventoSelect = eventoSelect;
	}

	public List<Evento> getListaEvento() {
		return listaEvento;
	}

	public void setListaEvento(List<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}

	public List<Docente> getListaDocente() {
		return listaDocente;
	}

	public void setListaDocente(List<Docente> listaDocente) {
		this.listaDocente = listaDocente;
	}

	public List<Barrio> getListaBarrio() {
		return listaBarrio;
	}

	public void setListaBarrio(List<Barrio> listaBarrio) {
		this.listaBarrio = listaBarrio;
	}

	public List<Carrera> getListaCarrera() {
		return listaCarrera;
	}

	public void setListaCarrera(List<Carrera> listaCarrera) {
		this.listaCarrera = listaCarrera;
	}

	public CatalogoAct getCatalogoAct() {
		return catalogoAct;
	}

	public void setCatalogoAct(CatalogoAct catalogoAct) {
		this.catalogoAct = catalogoAct;
	}

	public List<CatalogoAct> getListaCatalogoAct() {
		return listaCatalogoAct;
	}

	public void setListaCatalogoAct(List<CatalogoAct> listaCatalogoAct) {
		this.listaCatalogoAct = listaCatalogoAct;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public List<Estudiante> getListaEstudiante() {
		return listaEstudiante;
	}

	public void setListaEstudiante(List<Estudiante> listaEstudiante) {
		this.listaEstudiante = listaEstudiante;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public List<Estudiante> getListaEstudianteAux() {
		return listaEstudianteAux;
	}

	public void setListaEstudianteAux(List<Estudiante> listaEstudianteAux) {
		this.listaEstudianteAux = listaEstudianteAux;
	}

	public List<Vinculacion> getListaEstudianteVinculacion() {
		return listaEstudianteVinculacion;
	}

	public void setListaEstudianteVinculacion(List<Vinculacion> listaEstudianteVinculacion) {
		this.listaEstudianteVinculacion = listaEstudianteVinculacion;
	}

	public List<Object[]> getListaEstudianteVinculacionAux() {
		return listaEstudianteVinculacionAux;
	}

	public void setListaEstudianteVinculacionAux(List<Object[]> listaEstudianteVinculacionAux) {
		this.listaEstudianteVinculacionAux = listaEstudianteVinculacionAux;
	}

	public boolean isCheckDocEvent() {
		return checkDocEvent;
	}

	public void setCheckDocEvent(boolean checkDocEvent) {
		this.checkDocEvent = checkDocEvent;
	}

	public List<Docente> getListaDocenteAux() {
		return listaDocenteAux;
	}

	public void setListaDocenteAux(List<Docente> listaDocenteAux) {
		this.listaDocenteAux = listaDocenteAux;
	}

	public List<DocEvent> getListaDocEvent() {
		return listaDocEvent;
	}

	public void setListaDocEvent(List<DocEvent> listaDocEvent) {
		this.listaDocEvent = listaDocEvent;
	}

	public List<Object[]> getListaDocEventAux() {
		return listaDocEventAux;
	}

	public void setListaDocEventAux(List<Object[]> listaDocEventAux) {
		this.listaDocEventAux = listaDocEventAux;
	}

	public boolean isCheckActEvento() {
		return checkActEvento;
	}

	public void setCheckActEvento(boolean checkActEvento) {
		this.checkActEvento = checkActEvento;
	}

	public List<CatalogoAct> getListaCatalogoActAux() {
		return listaCatalogoActAux;
	}

	public void setListaCatalogoActAux(List<CatalogoAct> listaCatalogoActAux) {
		this.listaCatalogoActAux = listaCatalogoActAux;
	}

	public List<ActEvento> getListaActEvento() {
		return listaActEvento;
	}

	public void setListaActEvento(List<ActEvento> listaActEvento) {
		this.listaActEvento = listaActEvento;
	}

	public List<Object[]> getListaActEventotAux() {
		return listaActEventoAux;
	}

	public void setListaActEventotAux(List<Object[]> listaActEventotAux) {
		this.listaActEventoAux = listaActEventotAux;
	}

	public List<Object[]> getListaActEventoAux() {
		return listaActEventoAux;
	}

	public void setListaActEventoAux(List<Object[]> listaActEventoAux) {
		this.listaActEventoAux = listaActEventoAux;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<Proyecto> getListaProyecto() {
		return listaProyecto;
	}

	public void setListaProyecto(List<Proyecto> listaProyecto) {
		this.listaProyecto = listaProyecto;
	}

	public List<String> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<String> listaEstado) {
		this.listaEstado = listaEstado;
	}

}
