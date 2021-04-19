package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Dirigente;

public interface DirigenteServicioI {
	List<Dirigente> listar();

	void crear(Dirigente E);

	void actualizar(int id, Dirigente E);

	void eliminar(int id);

}
