package com.cortelalibertad.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cortelalibertad.api.models.Voto;
import com.cortelalibertad.api.repository.VotoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VotoService {
	
	@Autowired
	private VotoRepository repository;
	
	public Voto agregar(Voto dato) {
        boolean existe = repository.existsByUsuarioIdAndListaId(dato.getUsuario().getId(), dato.getLista().getId());
        if (existe) {
            throw new IllegalArgumentException("El usuario ya ha votado por esta lista.");
        }
        return repository.save(dato);
    }

    public Voto actualizar(Voto dato) {
        return repository.save(dato);
    }

	public Set<Voto> obtenerLists() {
		return new LinkedHashSet<>(repository.findAll());
	}

	public Voto obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

	public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("El voto con ID " + id + " no existe.");
        }
        repository.deleteById(id);
    }


    public List<Object[]> contarVotosPorLista() {
        return repository.contarVotosPorLista();
    }

    public Long contarTotalVotos() {
        return repository.contarTotalVotos();
    }
}
