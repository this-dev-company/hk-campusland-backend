package com.hackathon.hk_campusland_backend.auth.infrastructure.adapters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.auth.domain.dto.AuthResponse;
import com.hackathon.hk_campusland_backend.auth.domain.dto.LoginRequest;
import com.hackathon.hk_campusland_backend.auth.domain.dto.RegisterRequest;
import com.hackathon.hk_campusland_backend.auth.domain.models.Rol;
import com.hackathon.hk_campusland_backend.auth.domain.models.User;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.RoleRepository;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.UserRepository;
import com.hackathon.hk_campusland_backend.auth.infrastructure.security.jwt.JwtService;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

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

        Optional<User> existingUser_name = userRepository.findByUsername(request.getUsername());

        if (!existingUser_name.isPresent()) {
                throw new BusinessException("P-300", HttpStatus.CONFLICT, "El Usuario no existe");
            } 

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {

        Optional<User> existingUser_name = userRepository.findByUsername(request.getUsername());
        
        if (existingUser_name.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "El Usuario con ese nombre ya existe");
        } 

        
        List<Rol> roles = request.getRoles().stream()
                .map(roleName -> roleRepository.findByRol(roleName)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
                .collect(Collectors.toList());

                

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword())) 
                .roles(roles) 
                .audit(null)
                .enabled(true) 
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();

    }

}
