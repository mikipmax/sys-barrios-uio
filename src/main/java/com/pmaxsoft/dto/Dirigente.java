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
@Table(name = "dirigentes")

@PrimaryKeyJoinColumn(name = "id_persona")
@NamedQueries({ @NamedQuery(name = "Dirigente.findAll", query = "select E from Dirigente E") })
public class Dirigente extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio")
	private Barrio idBarrio;
	@ManyToOne
	@JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
	private Cargo idCargo;

	public Dirigente() {

	}

	public Dirigente(String cedula, String nombre, char genero, Barrio idBarrio, Cargo idCargo) {
		super(cedula, nombre, genero);
		this.idBarrio = idBarrio;
		this.idCargo = idCargo;
	}

	public Barrio getIdBarrio() {
		return idBarrio;
	}

	public void setIdBarrio(Barrio idBarrio) {
		this.idBarrio = idBarrio;
	}

	public Cargo getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Cargo idCargo) {
		this.idCargo = idCargo;
	}

}
