package com.pmaxsoft.dto;

import java.io.Serializable;

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
@Table(name = "proyectos")
@NamedQueries({ @NamedQuery(name = "Proyecto.findAll", query = "select E from Proyecto E") })
public class Proyecto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_proyecto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProyecto;
	@Column(name = "nombre_proyecto")
	private String nombreProyecto;
	private String objetivo;
	@Column(name = "marco_referencial")
	private String marcoReferencial;
	@Column(name = "marco_teorico")
	private String marcoTeorico;
	private String periodo;

	@JoinColumn(name = "id_programa", referencedColumnName = "id_programa")
	@ManyToOne
	private Programa idPrograma;

	public Proyecto() {

	}

	public Proyecto(String nombreProyecto, String objetivo, String marcoReferencial, String marcoTeorico,
			String periodo, Programa idPrograma) {
		this.nombreProyecto = nombreProyecto;
		this.objetivo = objetivo;
		this.marcoReferencial = marcoReferencial;
		this.marcoTeorico = marcoTeorico;
		this.periodo = periodo;
		this.idPrograma = idPrograma;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getMarcoReferencial() {
		return marcoReferencial;
	}

	public void setMarcoReferencial(String marcoReferencial) {
		this.marcoReferencial = marcoReferencial;
	}

	public String getMarcoTeorico() {
		return marcoTeorico;
	}

	public void setMarcoTeorico(String marcoTeorico) {
		this.marcoTeorico = marcoTeorico;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Programa getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Programa idPrograma) {
		this.idPrograma = idPrograma;
	}

}
