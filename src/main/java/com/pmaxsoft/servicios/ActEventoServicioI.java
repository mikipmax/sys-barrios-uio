package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.ActEvento;

public interface ActEventoServicioI {
	List<ActEvento> listar();

	List<ActEvento> listarActEvento(int id);

	void crear(ActEvento E);

	void actualizar(int id, ActEvento E);

	void eliminar(int id);

}
