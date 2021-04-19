package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.TipoAct;

public interface TipoActServicioI {
	List<TipoAct> listar();

	void crear(TipoAct E);

	void actualizar(int id, TipoAct E);

	void eliminar(int id);

}
