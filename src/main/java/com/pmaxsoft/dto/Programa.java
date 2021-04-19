package com.pmaxsoft.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "programas")
@NamedQueries({ @NamedQuery(name = "Programa.findAll", query = "select c from Programa c") })
public class Programa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_programa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrograma;
	@Column(name = "nombre_programa")
	private String nombrePrograma;
	private String mision;
	private String vision;
	private String objetivo;
	private String antecedentes;

	public Programa() {

	}

	public Programa(String nombrePrograma, String mision, String vision, String objetivo, String antecedentes) {
		this.nombrePrograma = nombrePrograma;
		this.mision = mision;
		this.vision = vision;
		this.objetivo = objetivo;
		this.antecedentes = antecedentes;
	}

	public int getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(int idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getNombrePrograma() {
		return nombrePrograma;
	}

	public void setNombrePrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;
	}

	public String getMision() {
		return mision;
	}

	public void setMision(String mision) {
		this.mision = mision;
	}

	public String getVision() {
		return vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

}
