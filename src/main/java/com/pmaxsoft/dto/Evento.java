package com.pmaxsoft.dto;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "eventos")
@NamedQueries({ @NamedQuery(name = "Evento.findAll", query = "select E from Evento E"),
		@NamedQuery(name = "Evento.findActivos", query = "select E from Evento E where E.estadoEvento =: estadoEvento") })
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_evento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;
	@Column(name = "nombre_evento")
	private String nombreEvento;
	@JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio")
	@ManyToOne
	private Barrio idBarrio;
	@JoinColumn(name = "id_carr", referencedColumnName = "id_carr")
	@ManyToOne
	private Carrera idCarr;
	@JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
	@ManyToOne
	private Proyecto idProyecto;
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	private double duracion;
	private String review;

	@Column(name = "estado_evento")
	private String estadoEvento = "En proceso";

	public Evento(int idEvento) {

		this.idEvento = idEvento;

	}

	public Evento() {

	}

	public Evento(String nombreEvento, Barrio idBarrio, Carrera idCarr, Proyecto idProyecto, Date fechaInicio,
			double duracion, String review, String estadoEvento) {
		this.nombreEvento = nombreEvento;
		this.idBarrio = idBarrio;
		this.idCarr = idCarr;
		this.idProyecto = idProyecto;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.review = review;
		this.estadoEvento = estadoEvento;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public Barrio getIdBarrio() {
		return idBarrio;
	}

	public void setIdBarrio(Barrio idBarrio) {
		this.idBarrio = idBarrio;
	}

	public Carrera getIdCarr() {
		return idCarr;
	}

	public void setIdCarr(Carrera idCarr) {
		this.idCarr = idCarr;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getEstadoEvento() {
		return estadoEvento;
	}

	public void setEstadoEvento(String estadoEvento) {
		this.estadoEvento = estadoEvento;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public Proyecto getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Proyecto idProyecto) {
		this.idProyecto = idProyecto;
	}

}
