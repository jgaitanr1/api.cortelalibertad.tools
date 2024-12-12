package com.cortelalibertad.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cortelalibertad.api.models.Lista;
import com.cortelalibertad.api.repository.ListaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListaService {
	@Autowired
	private ListaRepository listaRepository;
	
	public Lista agregar(Lista lista) {
		return listaRepository.save(lista);
	}

	public Lista actualizar(Lista lista) {
		return listaRepository.save(lista);
	}

	public Set<Lista> obtenerLists() {
		return new LinkedHashSet<>(listaRepository.findAll());
	}

	public Lista obtener(Integer id) {
		return listaRepository.findById(id).get();
	}

	public Lista obtenerCodigo(String codigo) {
		return listaRepository.findByCodigo(codigo).get();
	}

	public void eliminar(Integer id) {
		Lista lista = new Lista();
		lista.setId(id);
		listaRepository.delete(lista);
	}
}
