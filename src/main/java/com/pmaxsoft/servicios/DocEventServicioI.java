package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.DocEvent;

public interface DocEventServicioI {
	List<DocEvent> listar();

	List<DocEvent> listarDocEvent(int id);

	void crear(DocEvent E);

	void actualizar(int id, DocEvent E);

	void eliminar(int id);

}
