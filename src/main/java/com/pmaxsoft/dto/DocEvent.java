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

@Table(name = "doc_event")
@Entity
@NamedQueries({ @NamedQuery(name = "DocEvent.findAll", query = "select E from DocEvent E"),
		@NamedQuery(name = "DocEvent.findDocEvent", query = "select E from DocEvent E where E.idEvento.idEvento =: idEvento") })
public class DocEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_doc_event")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocEvent;

	@JoinColumn(name = "id_docente", referencedColumnName = "id_persona")
	@ManyToOne
	private Docente idDocente;
	@JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
	@ManyToOne
	private Evento idEvento;

	public DocEvent(Docente idDocente, Evento idEvento) {

		this.idDocente = idDocente;
		this.idEvento = idEvento;
	}

	public DocEvent(int idDocEvent, Docente idDocente, Evento idEvento) {
		this.idDocEvent = idDocEvent;
		this.idDocente = idDocente;
		this.idEvento = idEvento;
	}

	public DocEvent() {
	}

	public int getIdDocEvent() {
		return idDocEvent;
	}

	public void setIdDocEvent(int idDocEvent) {
		this.idDocEvent = idDocEvent;
	}

	public Docente getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(Docente idDocente) {
		this.idDocente = idDocente;
	}

	public Evento getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Evento idEvento) {
		this.idEvento = idEvento;
	}

}
