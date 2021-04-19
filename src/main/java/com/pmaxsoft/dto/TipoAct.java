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
@Table(name = "tipo_act")
@NamedQueries({ @NamedQuery(name = "TipoAct.findAll", query = "select E from TipoAct E") })
public class TipoAct implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_tipo_act")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoAct;
	@Column(name = "nombre_tipo_act")
	private String nombreTipoAct;

	public TipoAct() {

	}
	public TipoAct(int idTipoAct) {

		this.idTipoAct = idTipoAct;
	
	}
	public TipoAct(int idTipoAct, String nombreTipoAct) {

		this.idTipoAct = idTipoAct;
		this.nombreTipoAct = nombreTipoAct;
	}

	public TipoAct(String nombreTipoAct) {

		this.nombreTipoAct = nombreTipoAct;
	}

	public int getIdTipoAct() {
		return idTipoAct;
	}

	public void setIdTipoAct(int idTipoAct) {
		this.idTipoAct = idTipoAct;
	}

	public String getNombreTipoAct() {
		return nombreTipoAct;
	}

	public void setNombreTipoAct(String nombreTipoAct) {
		this.nombreTipoAct = nombreTipoAct;
	}

	@Override
	public String toString() {
		return "TipoAct [idTipoAct=" + idTipoAct + ", nombreTipoAct=" + nombreTipoAct + "]";
	}

}
