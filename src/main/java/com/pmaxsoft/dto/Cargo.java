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
@Table(name = "cargos")
@NamedQueries({ @NamedQuery(name = "Cargo.findAll", query = "select c from Cargo c") })
public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_cargo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCargo;
	@Column(name = "nombre_cargo")
	private String nombreCargo;

	public Cargo(int idCargo, String nombreCargo) {
		this.idCargo = idCargo;
		this.nombreCargo = nombreCargo;
	}

	public Cargo(String nombreCargo) {

		this.nombreCargo = nombreCargo;
	}

	public Cargo() {

	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNombreCargo() {
		return nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	@Override
	public String toString() {
		return "Cargo [idCargo=" + idCargo + ", nombreCargo=" + nombreCargo + "]";
	}

}
