package com.pmaxsoft.dto;

import java.io.Serializable;

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

@Table(name = "doc_programa")
@Entity
@NamedQueries({ @NamedQuery(name = "DocPrograma.findAll", query = "select E from DocPrograma E"),
		@NamedQuery(name = "DocPrograma.findDocPrograma", query = "select E from DocPrograma E where E.idPrograma.idPrograma =: idPrograma") })
public class DocPrograma implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_doc_programa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocPrograma;

	@JoinColumn(name = "id_docente", referencedColumnName = "id_persona")
	@ManyToOne
	private Docente idDocente;
	@JoinColumn(name = "id_programa", referencedColumnName = "id_programa")
	@ManyToOne
	private Programa idPrograma;

	public DocPrograma(Docente idDocente, Programa idPrograma) {
		this.idDocente = idDocente;
		this.idPrograma = idPrograma;
	}

	public DocPrograma() {
	}

	public int getIdDocPrograma() {
		return idDocPrograma;
	}

	public void setIdDocPrograma(int idDocPrograma) {
		this.idDocPrograma = idDocPrograma;
	}

	public Docente getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(Docente idDocente) {
		this.idDocente = idDocente;
	}

	public Programa getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Programa idPrograma) {
		this.idPrograma = idPrograma;
	}

}
