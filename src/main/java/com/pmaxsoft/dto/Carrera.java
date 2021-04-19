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
@Table(name = "carreras")
@NamedQueries({ @NamedQuery(name = "Carrera.findAll", query = "select E from Carrera E"),
		@NamedQuery(name = "Carrera.findActivos", query = "select E from Carrera E where E.estadoCarr =: estadoCarr") })
public class Carrera implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_carr")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarr;
	@Column(name = "nombre_carr")
	private String nombreCarr;
	@Column(name = "estado_carr")
	private String estadoCarr = "1";

	public Carrera() {

	}

	public Carrera(int idCarr) {

		this.idCarr = idCarr;

	}

	public Carrera(int idCarr, String nombreCarr, String estadoCarr) {
		this.idCarr = idCarr;
		this.nombreCarr = nombreCarr;
		this.estadoCarr = estadoCarr;

	}

	public Carrera(int idCarr, String nombreCarr) {

		this.idCarr = idCarr;
		this.nombreCarr = nombreCarr;

	}

	public Carrera(String nombreCarr) {

		this.nombreCarr = nombreCarr;

	}

	public int getIdCarr() {
		return idCarr;
	}

	public void setIdCarr(int idCarr) {
		this.idCarr = idCarr;
	}

	public String getNombreCarr() {
		return nombreCarr;
	}

	public void setNombreCarr(String nombreCarr) {
		this.nombreCarr = nombreCarr;
	}

	public String getEstadoCarr() {
		return estadoCarr;
	}

	public void setEstadoCarr(String estadoCarr) {
		this.estadoCarr = estadoCarr;
	}

	@Override
	public String toString() {
		return "Carrera [idCarr=" + idCarr + ", nombreCarr=" + nombreCarr + "]";
	}

}
