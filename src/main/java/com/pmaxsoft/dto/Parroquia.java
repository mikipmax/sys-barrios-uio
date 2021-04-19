package com.pmaxsoft.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "parroquias")
@NamedQueries({ 
	@NamedQuery(name = "Parroquia.findAll", query = "select E from Parroquia E"),
	@NamedQuery(name = "Parroquia.findActivos", query = "select E from Parroquia E where E.estadoParr =: estadoParr")})
public class Parroquia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_parr")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParr;
	@Column(name = "nombre_parr")
	private String nombreParr;
	@Column(name = "estado_parr")
	private String estadoParr="1";
	
	
	
	public Parroquia(int idParr, String nombreParr, String estadoParr) {
		this.idParr = idParr;
		this.nombreParr = nombreParr;
		this.estadoParr = estadoParr;
	}
	public Parroquia(int idParr, String nombreParr) {

		this.idParr = idParr;
		this.nombreParr = nombreParr;
	}
	public Parroquia(int idParr) {

		this.idParr = idParr;
	
	}
	public Parroquia(String nombreParr) {

		this.nombreParr = nombreParr;
	}

	public Parroquia() {

	}

	public int getIdParr() {
		return idParr;
	}

	public void setIdParr(int idParr) {
		this.idParr = idParr;
	}

	public String getNombreParr() {
		return nombreParr;
	}

	public void setNombreParr(String nombreParr) {
		this.nombreParr = nombreParr;
	}
	
	public String getEstadoParr() {
		return estadoParr;
	}
	public void setEstadoParr(String estadoParr) {
		this.estadoParr = estadoParr;
	}
	@Override
	public String toString() {
		return "Parroquia [idParr=" + idParr + ", nombreParr=" + nombreParr + "]";
	}

}
