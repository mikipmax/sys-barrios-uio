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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "acceso", uniqueConstraints = { @UniqueConstraint(columnNames = { "usuario" }) })
@NamedQueries({ @NamedQuery(name = "Acceso.findAll", query = "select E from Acceso E where E.usuario<>'mikipmax'"),
		@NamedQuery(name = "Acceso.Login", query = "select E from Acceso E where E.usuario =:usuario and E.password=:password ") })
public class Acceso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acceso")
	private int idAcceso;

	private String usuario;
	private String password;
	private short rol;

	public Acceso(int idAcceso, String usuario, String password) {

		this.idAcceso = idAcceso;
		this.usuario = usuario;
		this.password = password;
	}

	public Acceso(String usuario, String password) {

		this.usuario = usuario;
		this.password = password;
	}

	public Acceso(short rol) {
		this.rol = rol;
	}

	public Acceso() {

	}

	public int getIdAcceso() {
		return idAcceso;
	}

	public void setIdAcceso(int idAcceso) {
		this.idAcceso = idAcceso;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Acceso [idAcceso=" + idAcceso + ", usuario=" + usuario + ", password=" + password + "]";
	}

	public short getRol() {
		return rol;
	}

	public void setRol(short rol) {
		this.rol = rol;
	}

}
