package com.pmaxsoft.servicios;

import java.util.List;

import com.pmaxsoft.dto.Foto;

public interface FotoServicioI {
	List<Foto> listar();

	Foto buscar(int id);

	void crear(Foto E);

	void actualizar(int id, Foto E);

	void eliminar(int id);
	Foto buscarFotoEvento(int id);
	List<Foto> listaPorEvento(int id);
}
