package com.cortelalibertad.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cortelalibertad.api.models.User;
import com.cortelalibertad.api.payload.request.UserRequest;
import com.cortelalibertad.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	@Autowired
	private UserRepository usuarioRepository;
	
	public User agregarUsuario(User user) {
		return usuarioRepository.save(user);
	}
	
	public User actualizarUsuario(UserRequest userRequest) {
		User user= User.builder()
				.id(userRequest.getId())
				.username(userRequest.getUsername())
				.email(userRequest.getEmail())
				.password(userRequest.getPassword())
				.nombre(userRequest.getNombre())
				.apellido(userRequest.getApellido())
				.docIdentidad(userRequest.getDocIdentidad())
				.nroTelefono(userRequest.getNroTelefono())
				.escalafon(userRequest.getEscalafon())
				.regimen(userRequest.getRegimen())
				.ultSesion(userRequest.getUltSesion())
				.codVerificacion(userRequest.getCodVerificacion())
				.estado(userRequest.isEstado())
				.role(userRequest.getRole())
				.build();
		return usuarioRepository.save(user);
	}
	
	
	public Set<User> obtenerUsuarios() {
		return new LinkedHashSet<>(usuarioRepository.findAll());
	}

	
	public User obtenerUsuario(Integer id) {
		return usuarioRepository.findById(id).get();
	}

	
	public User obtenerUsuarioDNI(String docIdentidad) {
		return usuarioRepository.findByDocIdentidad(docIdentidad).get();
	}

	
	public void eliminarUsuario(Integer id) {
		User usr = new User();
        usr.setId(id);
        usuarioRepository.delete(usr);
	}
	
	public Long contarTotalUsuarios() {
        return usuarioRepository.contarTotalUsuarios();
    }
}
