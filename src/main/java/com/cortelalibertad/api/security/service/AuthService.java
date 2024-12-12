package com.cortelalibertad.api.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cortelalibertad.api.models.Role;
import com.cortelalibertad.api.models.User;
import com.cortelalibertad.api.payload.request.LoginRequest;
import com.cortelalibertad.api.payload.request.RegisterRequest;
import com.cortelalibertad.api.payload.response.AuthResponse;
import com.cortelalibertad.api.repository.UserRepository;
import com.cortelalibertad.api.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;	
    
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user=userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        String token=jwtService.getToken(user);
        
        return AuthResponse.builder()
                .token(token)
                .id(user.getId())
                .username(user.getUsername())
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .docIdentidad(user.getDocIdentidad())
                .escalafon(user.getEscalafon())
                .email(user.getEmail())
                .nroTelefono(user.getNroTelefono())
                .regimen(user.getRegimen())
                .ultSesion(user.getUltSesion())
                .estado(user.isEstado())
                .role(user.getRole()) 
                .build();
        //return authResponse;
        /*return AuthResponse.builder()
            .token(token)
            .build();*/

    }
    
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .nombre(request.getNombre())
            .apellido(request.getApellido())
            .docIdentidad(request.getDocIdentidad())
            .escalafon(request.getEscalafon())
            .email(request.getEmail())
            .nroTelefono(request.getNroTelefono())
            .regimen(request.getRegimen())
            .ultSesion(request.getUltSesion())
            .estado(request.isEstado())
            .role(Role.USER)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .id(user.getId())
            .username(user.getUsername())
            .nombre(user.getNombre())
            .apellido(user.getApellido())
            .docIdentidad(user.getDocIdentidad())
            .escalafon(user.getEscalafon())
            .email(user.getEmail())
            .nroTelefono(user.getNroTelefono())
            .regimen(user.getRegimen())
            .ultSesion(user.getUltSesion())
            .estado(user.isEstado())
            .role(user.getRole()) 
            .build();
        
    }
}
