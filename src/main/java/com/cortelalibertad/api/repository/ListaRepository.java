package com.cortelalibertad.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cortelalibertad.api.models.Lista;


public interface ListaRepository extends JpaRepository<Lista, Integer> {
	
	Optional<Lista> findByCodigo(String codigo); 
	
	Optional<Lista> findById(Long id);
	
	Optional<Lista> findByNombre(String nombre);

}
