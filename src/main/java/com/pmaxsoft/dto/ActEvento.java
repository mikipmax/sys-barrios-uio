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

@Entity
@Table(name = "act_evento")
@NamedQueries({ @NamedQuery(name = "ActEvento.findAll", query = "select E from ActEvento E"),
		@NamedQuery(name = "ActEvento.findActEvento", query = "select E from ActEvento E where E.idEvento.idEvento =: idEvento") })
public class ActEvento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_act_evento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActEvento;

	@JoinColumn(name = "id_cat_act", referencedColumnName = "id_cat_act")
	@ManyToOne
	private CatalogoAct idCatAct;
	@JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
	@ManyToOne
	private Evento idEvento;

	public ActEvento() {

	}

	public ActEvento(CatalogoAct idCatAct, Evento idEvento) {

		this.idCatAct = idCatAct;
		this.idEvento = idEvento;
	}

	public int getIdActEvento() {
		return idActEvento;
	}

	public void setIdActEvento(int idActEvento) {
		this.idActEvento = idActEvento;
	}

	public CatalogoAct getIdCatAct() {
		return idCatAct;
	}

	public void setIdCatAct(CatalogoAct idCatAct) {
		this.idCatAct = idCatAct;
	}

	public Evento getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Evento idEvento) {
		this.idEvento = idEvento;
	}

}
