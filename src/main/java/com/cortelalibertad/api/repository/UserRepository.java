package com.cortelalibertad.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cortelalibertad.api.models.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUsername(String username); 

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	Optional<User> findById(Long id);
	
	Optional<User> findByDocIdentidad(String docIdentidad);
	
	@Query("SELECT COUNT(u.id) FROM User u")
	Long contarTotalUsuarios();
}
