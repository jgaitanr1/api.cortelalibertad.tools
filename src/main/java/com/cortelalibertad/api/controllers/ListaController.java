package com.cortelalibertad.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cortelalibertad.api.models.Lista;
import com.cortelalibertad.api.security.service.ListaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lista")
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://161.132.50.180:3000" })
//@CrossOrigin("*")
public class ListaController {

	@Autowired
	private ListaService listaService;
	
	@GetMapping("/{id}")
	public Lista listarPorId(@PathVariable("id") Integer id) {
		return listaService.obtener(id);
	}
	
	@GetMapping("/{dato}")
	public Lista listarPorCodigo(@PathVariable("dato") String dato) {
		return listaService.obtenerCodigo(dato);
	}

	@GetMapping("/")
	public ResponseEntity<?> listarTodos() {
		return ResponseEntity.ok(listaService.obtenerLists());
	}
	
	@PostMapping("/")
	public ResponseEntity<Lista> guardar(@RequestBody Lista dato) {
		Lista entity = listaService.agregar(dato);
		return ResponseEntity.ok(entity);
	}
	
	@PutMapping("/")
	public Lista actualizar(@RequestBody Lista dato) {
		return listaService.actualizar(dato);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		listaService.eliminar(id);
	}
	
}
