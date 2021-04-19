package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Vinculacion;

public interface VinculacionServicioI {
	List<Vinculacion> listar();
	List<Vinculacion> listarEstudiantesVinculacion(int id);
	void crear(Vinculacion E);

	void actualizar(int id, Vinculacion E);

	void eliminar(int id);
	
	List<Vinculacion> listarActivos();

}
