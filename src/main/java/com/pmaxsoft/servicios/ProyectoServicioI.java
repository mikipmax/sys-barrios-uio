package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Proyecto;

public interface ProyectoServicioI {
	List<Proyecto> listar();

	Proyecto buscar(int id);

	void crear(Proyecto E);

	void actualizar(int id, Proyecto E);

	


}
