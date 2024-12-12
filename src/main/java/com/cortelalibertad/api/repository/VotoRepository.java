package com.cortelalibertad.api.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cortelalibertad.api.models.Voto;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
	
	Optional<Voto> findById(Long id);
	
	boolean existsByUsuarioIdAndListaId(Integer usuarioId, Integer listaId);

	@Query("SELECT v.lista.id, COUNT(v.id) FROM Voto v GROUP BY v.lista.id")
	List<Object[]> contarVotosPorLista();


    @Query("SELECT COUNT(v) FROM Voto v")
    Long contarTotalVotos();
	
}
