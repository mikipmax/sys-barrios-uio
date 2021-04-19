package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Parroquia;

public interface ParroquiaServicioI {
	List<Parroquia> listar();
	Parroquia buscar(int id);
	void crear(Parroquia E);

	void actualizar(int id, Parroquia E);

	void eliminar(int id);

	List<Parroquia> listarActivos();
}
