package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.DocPrograma;

public interface DocProgramaServicioI {
	List<DocPrograma> listar();

	List<DocPrograma> listarDocPrograma(int id);

	void crear(DocPrograma E);

	void actualizar(int id, DocPrograma E);

	void eliminar(int id);

}
