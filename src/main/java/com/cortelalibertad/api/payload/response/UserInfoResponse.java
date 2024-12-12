package com.cortelalibertad.api.payload.response;


import com.cortelalibertad.api.models.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
	
	String username;
	String email;
	String nombre;
	String apellido;
	String docIdentidad;
	String nroTelefono;
	String modulo;
	boolean estado;
	Role role;
}
