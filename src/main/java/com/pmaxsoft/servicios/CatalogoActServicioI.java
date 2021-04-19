package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.CatalogoAct;

public interface CatalogoActServicioI {
	List<CatalogoAct> listar();
	CatalogoAct buscar(int id);
	void crear(CatalogoAct E);

	void actualizar(int id, CatalogoAct E);

	void eliminar(int id);

	List<CatalogoAct> listarActivos();
}
