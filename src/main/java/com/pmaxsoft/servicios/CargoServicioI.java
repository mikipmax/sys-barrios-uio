package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Cargo;

public interface CargoServicioI {
	List<Cargo> listar();
	Cargo buscar(int id);
	void crear(Cargo E);

	void actualizar(int id, Cargo E);

	void eliminar(int id);

}
