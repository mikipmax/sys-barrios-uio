package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Revista;

public interface RevistaServicioI {
	List<Revista> listar();

	void crear(Revista E);

	void actualizar(int id, Revista E);

	void eliminar(int id);

}
