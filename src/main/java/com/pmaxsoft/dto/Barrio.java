package com.pmaxsoft.dto;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "barrios")
@NamedQueries({ 
	@NamedQuery(name = "Barrio.findAll", query = "select E from Barrio E"),
	@NamedQuery(name = "Barrio.findActivos", query = "select E from Barrio E where E.estadoBarrio =: estadoBarrio")})
public class Barrio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_barrio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBarrio;
	@Column(name = "nombre_barrio")
	private String nombreBarrio;
	@Column(name = "num_hab")
	private int numHab;
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	@Column(name = "es_legal")
	private boolean esLegal;
	@Column(name = "estado_barrio")
	private String estadoBarrio="1";
	@JoinColumn(name = "id_parr", referencedColumnName = "id_parr")
	@ManyToOne
	private Parroquia idParr;
	private String diagnostico;
	public Barrio() {

	}

	public Barrio(int idBarrio) {

		this.idBarrio = idBarrio;

	}

	public Barrio(int idBarrio, String nombreBarrio, int numHab, Date fechaCreacion, boolean esLegal,
			String estadoBarrio, Parroquia idParr) {
		this.idBarrio = idBarrio;
		this.nombreBarrio = nombreBarrio;
		this.numHab = numHab;
		this.fechaCreacion = fechaCreacion;
		this.esLegal = esLegal;
		this.estadoBarrio = estadoBarrio;
		this.idParr = idParr;
	}

	public Barrio(int idBarrio, String nombreBarrio, int numHab, Date fechaCreacion, boolean esLegal,
			Parroquia idParr) {

		this.idBarrio = idBarrio;
		this.nombreBarrio = nombreBarrio;
		this.numHab = numHab;
		this.fechaCreacion = fechaCreacion;
		this.esLegal = esLegal;
		this.idParr = idParr;
	}

	public Barrio(String nombreBarrio, int numHab, Date fechaCreacion, boolean esLegal, Parroquia idParr) {

		this.nombreBarrio = nombreBarrio;
		this.numHab = numHab;
		this.fechaCreacion = fechaCreacion;
		this.esLegal = esLegal;
		this.idParr = idParr;
	}

	public Barrio(String nombreBarrio, int numHab, boolean esLegal, Parroquia idParr) {

		this.nombreBarrio = nombreBarrio;
		this.numHab = numHab;
		this.esLegal = esLegal;
		this.idParr = idParr;
	}

	public int getIdBarrio() {
		return idBarrio;
	}

	public void setIdBarrio(int idBarrio) {
		this.idBarrio = idBarrio;
	}

	public String getNombreBarrio() {
		return nombreBarrio;
	}

	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}

	public int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		this.numHab = numHab;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean isEsLegal() {
		return esLegal;
	}

	public void setEsLegal(boolean esLegal) {
		this.esLegal = esLegal;
	}

	public Parroquia getIdParr() {
		return idParr;
	}

	public void setIdParr(Parroquia idParr) {
		this.idParr = idParr;
	}

	public String getEstadoBarrio() {
		return estadoBarrio;
	}

	public void setEstadoBarrio(String estadoBarrio) {
		this.estadoBarrio = estadoBarrio;
	}



	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
}
