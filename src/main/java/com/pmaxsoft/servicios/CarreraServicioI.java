package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Carrera;

public interface CarreraServicioI {
	List<Carrera> listar();
	Carrera buscar(int id);
	void crear(Carrera E);

	void actualizar(int id, Carrera E);

	void eliminar(int id);

	List<Carrera> listarActivos();
}
