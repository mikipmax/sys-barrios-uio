package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Barrio;

public interface BarrioServicioI {
	List<Barrio> listar();
	Barrio buscar(int id);
	void crear(Barrio E);

	void actualizar(int id, Barrio E);

	void eliminar(int id);
	
	List<Barrio> listarActivos();
}
