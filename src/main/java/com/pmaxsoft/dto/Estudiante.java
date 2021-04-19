package com.pmaxsoft.dto;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "estudiantes")

@PrimaryKeyJoinColumn(name = "id_persona")
@NamedQueries({ @NamedQuery(name = "Estudiante.findAll", query = "select E from Estudiante E") })
public class Estudiante extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_carr", referencedColumnName = "id_carr")
	private Carrera idCarr;
	private short semestre;
	public Estudiante() {

	}

	public Estudiante(String cedula, String nombre, char genero, Carrera idCarr, short semestre) {
		super(cedula, nombre, genero);
		this.idCarr = idCarr;
		this.semestre=semestre;
	}

	public Carrera getIdCarr() {
		return idCarr;
	}

	public void setIdCarr(Carrera idCarr) {
		this.idCarr = idCarr;
	}

	public short getSemestre() {
		return semestre;
	}

	public void setSemestre(short semestre) {
		this.semestre = semestre;
	}

}
