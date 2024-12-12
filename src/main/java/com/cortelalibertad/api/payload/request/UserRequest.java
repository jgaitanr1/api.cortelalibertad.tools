package com.cortelalibertad.api.payload.request;




import com.cortelalibertad.api.models.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	int id;
	String username;
	String password;
	String nombre;
	String apellido;
	String docIdentidad;
	String escalafon;
	String email;
	String nroTelefono;
	String regimen;
	String ultSesion;
	boolean estado;
	Role role;
	//boolean enabled;
}
