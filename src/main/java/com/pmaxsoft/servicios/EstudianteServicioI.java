package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Estudiante;

public interface EstudianteServicioI {
	List<Estudiante> listar();

	void crear(Estudiante E);

	void actualizar(int id, Estudiante E);

	void eliminar(int id);

}
