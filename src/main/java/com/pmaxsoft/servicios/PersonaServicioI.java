package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Persona;

public interface PersonaServicioI {
	List<Persona> listar();
	void crear(Persona per);
	void actualizar(int id,Persona per);
	void eliminar(int id);
	List<Persona> listarActivos();
}
