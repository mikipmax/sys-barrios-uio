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
@Table(name = "revistas")
@NamedQueries({ @NamedQuery(name = "Revista.findAll", query = "select c from Revista c") })
public class Revista implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_revista")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRevista;
	@Column(name = "nombre_revista")
	private String nombreRevista;
	@Column(name = "url_revista")
	private String urlRevista;

	public Revista(String nombreRevista, String urlRevista) {

		this.nombreRevista = nombreRevista;
		this.urlRevista = urlRevista;
	}

	public Revista() {
	}

	public int getIdRevista() {
		return idRevista;
	}

	public void setIdRevista(int idRevista) {
		this.idRevista = idRevista;
	}

	public String getNombreRevista() {
		return nombreRevista;
	}

	public void setNombreRevista(String nombreRevista) {
		this.nombreRevista = nombreRevista;
	}

	public String getUrlRevista() {
		return urlRevista;
	}

	public void setUrlRevista(String urlRevista) {
		this.urlRevista = urlRevista;
	}

}
