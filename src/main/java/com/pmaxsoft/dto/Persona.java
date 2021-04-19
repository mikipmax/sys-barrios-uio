package com.pmaxsoft.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({ 
	@NamedQuery(name = "Persona.findAll", query = "select p from Persona p"),
	@NamedQuery(name = "Persona.findActivos", query = "select p from Persona p where p.estadoPersona =: estadoPersona")})
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")

	@Id
	private int idPersona;
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	private char genero;
	

	@Column(name = "estado_persona")
	private String estadoPersona="1";

	public Persona(String cedula, String nombre) {

		this.cedula = cedula;
		this.nombre = nombre;
	}

	public Persona(String cedula, String nombre, char genero) {
		this.genero = genero;

		this.cedula = cedula;
		this.nombre = nombre;
	}

	public Persona(int idPersona, String cedula, String nombre, String apellido, String telefono, String correo,
			char genero,  String estadoPersona) {
		this.idPersona = idPersona;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.genero = genero;
	
		this.estadoPersona = estadoPersona;
	}

	public Persona(int idPersona) {
		this.idPersona = idPersona;

	}

	public Persona() {

	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}



	public String getEstadoPersona() {
		return estadoPersona;
	}

	public void setEstadoPersona(String estadoPersona) {
		this.estadoPersona = estadoPersona;
	}

}
