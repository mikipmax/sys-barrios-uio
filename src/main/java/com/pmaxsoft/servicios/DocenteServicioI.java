package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Docente;

public interface DocenteServicioI {
	List<Docente> listar();
	Docente buscar(int id);
	void crear(Docente E);

	void actualizar(int id, Docente E);

	void eliminar(int id);

}
