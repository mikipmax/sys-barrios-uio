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
@Table(name = "catalogo_act")
@NamedQueries({ 
	@NamedQuery(name = "CatalogoAct.findAll", query = "select E from CatalogoAct E"),
	@NamedQuery(name = "CatalogoAct.findActivos", query = "select E from CatalogoAct E where E.estadoCatAct =: estadoCatAct")})
public class CatalogoAct implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_cat_act")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCatAct;
	@Column(name = "nombre_cat_act")
	private String nombreCatAct;
	@Column(name = "estado_cat_act")
	private String estadoCatAct="1";
	

	public CatalogoAct() {

	}

	public CatalogoAct(int idCatAct) {

		this.idCatAct = idCatAct;

	}
	
	public CatalogoAct(int idCatAct, String nombreCatAct, String estadoCatAct) {
		this.idCatAct = idCatAct;
		this.nombreCatAct = nombreCatAct;
		this.estadoCatAct = estadoCatAct;
	}

	public CatalogoAct(int idCatAct, String nombreCatAct) {
		
		this.idCatAct = idCatAct;
		this.nombreCatAct = nombreCatAct;
	}

	public int getIdCatAct() {
		return idCatAct;
	}

	public void setIdCatAct(int idCatAct) {
		this.idCatAct = idCatAct;
	}

	public String getNombreCatAct() {
		return nombreCatAct;
	}

	public void setNombreCatAct(String nombreCatAct) {
		this.nombreCatAct = nombreCatAct;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEstadoCatAct() {
		return estadoCatAct;
	}

	public void setEstadoCatAct(String estadoCatAct) {
		this.estadoCatAct = estadoCatAct;
	}

}
