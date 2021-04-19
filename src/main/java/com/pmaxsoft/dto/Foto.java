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
@Table(name = "fotos")
@NamedQueries({ 
	@NamedQuery(name = "Foto.findAll", query = "select E from Foto E"),
	@NamedQuery(name = "Foto.findByEvento", query = "select E from Foto E where E.idEvento.idEvento=:idEvento")})
public class Foto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto")
	private int idFoto;
	
	private byte[] foto;
	@ManyToOne
	@JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
	private Evento idEvento;
	
	public Foto() {
	}

	public Foto(byte[] foto, Evento idEvento) {

		this.foto = foto;
		this.idEvento = idEvento;
	}

	public Foto(byte[] foto) {

		this.foto = foto;

	}

	public int getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Evento getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Evento idEvento) {
		this.idEvento = idEvento;
	}

}
