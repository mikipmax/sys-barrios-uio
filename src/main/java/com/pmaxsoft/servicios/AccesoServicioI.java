package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Acceso;

public interface AccesoServicioI {
	List<Acceso> listar();
	Acceso login(Acceso E);
	void crear(Acceso E);

	void actualizar(int id, Acceso E);

	void eliminar(int id);

}
