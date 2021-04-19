package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Evento;

public interface EventoServicioI {
	List<Evento> listar();

	void crear(Evento E);

	void actualizar(int id, Evento E);

	void eliminar(int id);
	
	List<Evento> listarActivos();

}
