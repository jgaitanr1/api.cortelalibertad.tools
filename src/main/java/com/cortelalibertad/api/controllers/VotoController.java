package com.cortelalibertad.api.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.cortelalibertad.api.models.Voto;
import com.cortelalibertad.api.security.service.VotoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/voto")
@RequiredArgsConstructor
@CrossOrigin(origins = { "https://subcafae.cortejusticialalibertad.com" })
//@CrossOrigin("*")
public class VotoController {

	@Autowired
	private VotoService service;
	
	@GetMapping("/{id}")
	public Voto listarPorId(@PathVariable("id") Integer id) {
		return service.obtener(id);
	}
	

	@GetMapping("/")
	public ResponseEntity<?> listarTodos() {
		return ResponseEntity.ok(service.obtenerLists());
	}
	
	@PostMapping("/")
	public ResponseEntity<?> guardar(@RequestBody Voto dato) {
	    try {
	        Voto entity = service.agregar(dato);
	        return ResponseEntity.ok(entity);
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}
	
	@PutMapping("/")
	public Voto actualizar(@RequestBody Voto dato) {
		return service.actualizar(dato);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}

    @GetMapping("/conteo")
    public List<Map<String, Object>> contarVotosPorLista() {
        return service.contarVotosPorLista().stream()
            .map(result -> Map.of("listaId", result[0], "cantidadVotos", result[1]))
            .collect(Collectors.toList());
    }

    @GetMapping("/total")
    public Long contarTotalVotos() {
        return service.contarTotalVotos();
    }
}
