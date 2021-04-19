package com.pmaxsoft.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "vinculacion")
@NamedQueries({ 
	@NamedQuery(name = "Vinculacion.findAll", query = "select E from Vinculacion E"),
	@NamedQuery(name = "Vinculacion.findActivos", query = "select E from Vinculacion E where E.estadoVinculacion =: estadoVinculacion"),
	@NamedQuery(name = "Vinculacion.findEstudiantesVinculacion", query = "select E from Vinculacion E where E.idEvento.idEvento =: idEvento")})
public class Vinculacion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_vinculacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVinculacion;

	@JoinColumn(name = "id_estudiante", referencedColumnName = "id_persona")
	@ManyToOne
	private Estudiante idEstudiante;
	@JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
	@ManyToOne
	private Evento idEvento;

	@Column(name = "estado_vinculacion")
	private String estadoVinculacion="1";
	
	public Vinculacion() {

	}

	public Vinculacion(int idVinculacion) {

		this.idVinculacion = idVinculacion;

	}

	public Vinculacion(int idVinculacion, Estudiante idEstudiante, Evento idEvento, String estadoVinculacion) {
		this.idVinculacion = idVinculacion;
		this.idEstudiante = idEstudiante;
		this.idEvento = idEvento;
		this.estadoVinculacion = estadoVinculacion;
	}

	public Vinculacion(int idVinculacion, Estudiante idEstudiante, Evento idEvento) {

		this.idVinculacion = idVinculacion;
		this.idEstudiante = idEstudiante;
		this.idEvento = idEvento;
	}

	public Vinculacion(Estudiante idEstudiante, Evento idEvento) {

		this.idEstudiante = idEstudiante;
		this.idEvento = idEvento;
	}
	public Vinculacion(Evento idEvento) {

		this.idEvento = idEvento;
	}
	public int getIdVinculacion() {
		return idVinculacion;
	}

	public void setIdVinculacion(int idVinculacion) {
		this.idVinculacion = idVinculacion;
	}

	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public Evento getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Evento idEvento) {
		this.idEvento = idEvento;
	}

	public String getEstadoVinculacion() {
		return estadoVinculacion;
	}

	public void setEstadoVinculacion(String estadoVinculacion) {
		this.estadoVinculacion = estadoVinculacion;
	}

	
}
