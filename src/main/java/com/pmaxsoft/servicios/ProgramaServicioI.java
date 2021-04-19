package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Programa;

public interface ProgramaServicioI {
	List<Programa> listar();

	Programa buscar(int id);

	void crear(Programa E);

	void actualizar(int id, Programa E);

	void eliminar(int id);

}
