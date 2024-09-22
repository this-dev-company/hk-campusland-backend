package com.hackathon.hk_campusland_backend.auth.infrastructure.adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.auth.domain.dto.AuthResponse;
import com.hackathon.hk_campusland_backend.auth.domain.dto.LoginRequest;
import com.hackathon.hk_campusland_backend.auth.domain.dto.RegisterRequest;
import com.hackathon.hk_campusland_backend.auth.domain.models.User;
import com.hackathon.hk_campusland_backend.auth.domain.models.UserRole;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.RoleRepository;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.UserRepository;
import com.hackathon.hk_campusland_backend.auth.infrastructure.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthAdapter {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository; // Repositorio para guardar el usuario
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {

        // Buscar los roles por nombre y convertirlos en una lista de objetos UserRole
        List<UserRole> userRoles = request.getRoles().stream()
                .map(roleName -> roleRepository.findByRol(roleName)
                .map(role -> UserRole.builder()
                        .user(null) // Este valor será asignado después
                        .rol(role)
                        .build())
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
                .collect(Collectors.toList());

        

        // Crear el usuario
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword())) // Encriptar la contraseña
                .roles(userRoles) // Asignar los roles convertidos a UserRole
                .enabled(true) // Habilitar el usuario por defecto
                .build();
        
                

        // Establecer el usuario en los objetos UserRole
        userRoles.forEach(userRole -> userRole.setUser(user));

        
        

        // Guardar el usuario
        userRepository.save(user);

        System.out.println("""
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                        """);

        // Generar el token JWT
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

}
